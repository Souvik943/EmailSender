package com.souvik.EmailSender.controllers;

import com.souvik.EmailSender.common.CommonUtils;
import com.souvik.EmailSender.common.CustomResponse;
import com.souvik.EmailSender.requests.EmailRequest;
import com.souvik.EmailSender.services.EmailService;
import com.souvik.EmailSender.validations.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/email")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    Validations validations = new Validations();

    @PostMapping(value = "/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmailwithHTML(emailRequest.getSendTo(), emailRequest.getSubject(), emailRequest.getMessage());
        if(validations.isSendToValid(emailRequest.getSendTo())) {
            return ResponseEntity.ok(
                    CustomResponse.builder().httpStatus(HttpStatus.OK).success(true).message(CommonUtils.EMAIL_IS_SENT).build()
            );
        }
        else {
            return ResponseEntity.ok(
                    CustomResponse.builder().httpStatus(HttpStatus.BAD_REQUEST).success(false).message(CommonUtils.ERROR_SEND_TO).build()
            );
        }
    }

    @PostMapping(value = "/send-with-file")
    public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestPart EmailRequest emailRequest, @RequestPart MultipartFile multipartFile) throws IOException {
        emailService.sendEmailWithFile(emailRequest.getSendTo(), emailRequest.getSubject(), emailRequest.getMessage(), multipartFile.getInputStream());
        if(validations.isSendToValid(emailRequest.getSendTo())) {
            return ResponseEntity.ok(
                    CustomResponse.builder().httpStatus(HttpStatus.OK).success(true).message(CommonUtils.EMAIL_IS_SENT).build()
            );
        }
        else {
            return ResponseEntity.ok(
                    CustomResponse.builder().httpStatus(HttpStatus.BAD_REQUEST).success(false).message(CommonUtils.ERROR_SEND_TO).build()
            );
        }
    }


}
