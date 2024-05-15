package com.souvik.EmailSender.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    void sendEmailToSingle(String sendTo, String subject, String message);

    void sendEmailToMultiple(String[] sendTo, String subject, String message);

    void sendEmailwithHTML(String sendTo, String subject, String htmlContent);

    void sendEmailWithFile(String sendTo, String subject, String message, File file);

    void sendEmailWithFile(String sendTo, String subject, String message, InputStream inputStream);


}
