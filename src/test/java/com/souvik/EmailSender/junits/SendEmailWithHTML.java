package com.souvik.EmailSender.junits;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SendEmailWithHTML {

    @Autowired
    private EmailService emailService;

    private final Logger logger = LoggerFactory.getLogger(SendEmailWithHTML.class);
    @Test
    void emailSendTestToSingular(){
        logger.info(CommonUtils.EMAIL_IS_SENDING);
        String htmlContent = ""+"<h1 style='colour:blue'>This Email contains html</h1>" +
                "";
        emailService.sendEmailwithHTML("souvikkarmakar2k19@gmail.com","Email Sending Test",htmlContent);
    }
}
