package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment env;

    @Async
    public void sendNotificaition(AppUser user) throws MailException, InterruptedException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Activate your account");
        mail.setText("http://localhost:8080/users/activate/ru/" + user.getEmail());
        javaMailSender.send(mail);

        System.out.println("Email sent!");
    }
}
