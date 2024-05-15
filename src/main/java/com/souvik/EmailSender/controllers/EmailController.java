package com.souvik.EmailSender.controllers;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.common.CustomResponse;
import com.souvik.EmailSender.requests.EmailRequest;
import com.souvik.EmailSender.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/api/email")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmailwithHTML(emailRequest.getSendTo(), emailRequest.getSubject(), emailRequest.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder().message(CommonUtils.EMAIL_IS_SENT).httpStatus(HttpStatus.OK).success(true).build()
        );
    }


}
