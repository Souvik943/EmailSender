package com.souvik.EmailSender.junits;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class SendEmailWithFile {

    @Autowired
    private EmailService emailService;

    private final Logger logger = LoggerFactory.getLogger(SendEmailWithFile.class);
    @Test
    void emailSendTestWithFile(){
        logger.info(CommonUtils.EMAIL_IS_SENDING);
//        emailService.sendEmailWithFile("souvikkarmakar2k19@gmail.com","Email with a File","Sending this email with an attachment",new File("Downloads/Souvik_Resume"));
        emailService.sendEmailWithFile("souvikkarmakar2k19@gmail.com","Email with a File","Sending this email with an attachment",new File("C:\\Users\\souvi\\Souvik\\Projects\\Email-Sender\\src\\main\\resources\\static\\Souvik_Resume.pdf"));
    }
}
