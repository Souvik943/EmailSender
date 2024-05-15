package com.souvik.EmailSender.services.impl;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

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
            javaMailSender.send(mimeMessage);
            logger.info(CommonUtils.EMAIL_IS_SENT);
        }
        catch (MessagingException m) {
            throw new RuntimeException(m);
        }
    }

    @Override
    public void sendEmailWithFile(String sendTo, String subject, File file) {

    }
}
