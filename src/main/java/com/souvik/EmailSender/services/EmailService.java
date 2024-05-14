package com.souvik.EmailSender.services;

import java.io.File;

public interface EmailService {

    void sendEmailToSingle(String sendTo, String subject, String message);

    void sendEmailToMultiple(String[] sendTo, String subject, String message);

    void sendEmailwithHTML(String sendTo, String subject, String htmlContent);

    void sendEmailWithFile(String sendTo, String subject, File file);


}
