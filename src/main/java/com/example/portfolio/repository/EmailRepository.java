package com.example.portfolio.repository;

import freemarker.template.TemplateException;
import org.springframework.stereotype.Repository;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;
//import org.springframework.boot.demo.model.Mail;

@Repository
public interface EmailRepository {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        String ...templateModel);
    void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);

    void sendMessageUsingThymeleafTemplate(String to,
                                           String subject,
                                           Map<String, Object> templateModel)
            throws IOException, MessagingException;

    void sendMessageUsingFreemarkerTemplate(String to,
                                            String subject,
                                            Map<String, Object> templateModel)
            throws IOException, TemplateException, MessagingException;
}
