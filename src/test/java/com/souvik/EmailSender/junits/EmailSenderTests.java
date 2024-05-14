package com.souvik.EmailSender.junits;

import com.souvik.EmailSender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderTests {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){
        emailService.sendEmailToSingle("souvikkarmakar2k19@gmail.com","Email Sending Test","Sending this email to a single person for testing purposes.");
    }
}
