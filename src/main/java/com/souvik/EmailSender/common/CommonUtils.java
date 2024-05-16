package com.souvik.EmailSender.common;

import java.util.regex.Pattern;

public class CommonUtils {

    public static final String EMAIL_IS_SENT = "Email is sent successfully .";
    public static final String EMAIL_IS_SENDING = "Email is being sent ... ";
    public static final String SEND_FROM = "souvikkarmakar2k19@gmail.com";
    public static final String TRUE = "TRUE";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String ERROR_SEND_TO = "The recipient email address is invalid .";
    public static final String ERROR = "There are some errors .";

}
