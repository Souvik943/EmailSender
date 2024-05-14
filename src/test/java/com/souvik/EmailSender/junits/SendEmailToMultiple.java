package com.souvik.EmailSender.junits;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SendEmailToMultiple {

    @Autowired
    private EmailService emailService;

    private final Logger logger = LoggerFactory.getLogger(SendEmailToMultiple.class);
    @Test
    void emailSendTestToMultiple(){
        logger.info(CommonUtils.EMAIL_IS_SENDING);
        emailService.sendEmailToMultiple(new String[]{"souvikkarmakar2k19@gmail.com", "sharmisthakarmakar2017@gmail.com"},"Sending Email to multiple people","Sending this email to multiple people .");
    }
}
