package com.example.services;

import com.example.configs.AppParamsConfig;
import com.example.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    private final AppParamsConfig appConfig;

    public EmailService(AppParamsConfig appConfig) {
        this.appConfig = appConfig;
    }

    public boolean sendSimpleEmail(String subject, String text, String name, String telephone) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(appConfig.getToEmail());
        System.out.println("Sending email to " + appConfig.getToEmail());
        message.setSubject(subject);
        message.setText(MessageFormat.format(Constants.MY_NAME_PREFIX, name) +
               MessageFormat.format(Constants.MY_TEL_PREFIX, telephone) + text);
        message.setFrom(Constants.FROM_EMAIL);
        try {
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            logger.info("Error sending email: " + e.getMessage());
            return false;
        }
    }
}

