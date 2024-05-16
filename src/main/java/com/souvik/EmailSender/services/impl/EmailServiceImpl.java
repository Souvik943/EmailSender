package com.souvik.EmailSender.services.impl;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.common.CustomResponse;
import com.souvik.EmailSender.services.EmailService;
import com.souvik.EmailSender.validations.Validations;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    Validations validations = new Validations();

    @Override
    public void sendEmailToSingle(String sendTo, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(CommonUtils.SEND_FROM);
        javaMailSender.send(simpleMailMessage);
        logger.info(CommonUtils.EMAIL_IS_SENT);
    }

    @Override
    public void sendEmailToMultiple(String[] sendTo, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(CommonUtils.SEND_FROM);
        javaMailSender.send(simpleMailMessage);
        logger.info(CommonUtils.EMAIL_IS_SENT);
    }

    @Override
    public void sendEmailwithHTML(String sendTo, String subject, String htmlContent) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setText(htmlContent,true);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(CommonUtils.SEND_FROM);

            if(validations.isSendToValid(sendTo)) {
                logger.info(CommonUtils.EMAIL_IS_SENDING);
                javaMailSender.send(mimeMessage);
                logger.info(CommonUtils.EMAIL_IS_SENT);
            }
            else {
                logger.info(CommonUtils.ERROR);
            }
        }
        catch (MessagingException m) {
            throw new RuntimeException(m);
        }
    }

    @Override
    public void sendEmailWithFile(String sendTo, String subject, String message, File file) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(CommonUtils.SEND_FROM);
            mimeMessageHelper.setText(message);

            FileSystemResource fileSystemResource = new FileSystemResource(file);
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),file);

            javaMailSender.send(mimeMessage);
            logger.info(CommonUtils.EMAIL_IS_SENT);
        }
        catch (MessagingException m) {
            throw new RuntimeException(m);
        }
    }

    @Override
    public void sendEmailWithFile(String sendTo, String subject, String message, InputStream inputStream) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(CommonUtils.SEND_FROM);
            mimeMessageHelper.setText(message);

            File file = new File("C:\\Users\\souvi\\Souvik\\Projects\\Email-Sender\\src\\main\\resources\\static\\Souvik_Resume.pdf");
            Files.copy(inputStream,file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),file);

            if(validations.isSendToValid(sendTo)) {
                logger.info(CommonUtils.EMAIL_IS_SENDING);
                javaMailSender.send(mimeMessage);
                logger.info(CommonUtils.EMAIL_IS_SENT);
            }
            else {
                logger.info(CommonUtils.ERROR);
            }
        }
        catch (MessagingException | IOException m) {
            throw new RuntimeException(m);
        }
    }
}
