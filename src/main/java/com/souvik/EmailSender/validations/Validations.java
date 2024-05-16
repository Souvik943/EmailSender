package com.souvik.EmailSender.validations;

import com.souvik.EmailSender.common.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;

public class Validations {
    @Autowired
    public Validations() {
    }

    private final Logger logger = LoggerFactory.getLogger(Validations.class);

    public boolean isSendToValid(String sendTo) {
        Matcher matcher = CommonUtils.VALID_EMAIL_ADDRESS_REGEX.matcher(sendTo);
        return matcher.matches();
    }

}
