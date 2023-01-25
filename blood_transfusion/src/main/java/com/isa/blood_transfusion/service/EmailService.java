package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment env;

    @Async
    public void sendActivationLink(AppUser user) throws MailException, InterruptedException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Activate your account");
        mail.setText("http://localhost:8080/users/activate/ru/" + user.getEmail());
        javaMailSender.send(mail);

        System.out.println("Email sent!");
    }

    public void sendEmail(String toAddress, String subject, String message, String filePath) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);

        try {
            helper.setTo(toAddress);
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setSubject(subject);
            helper.setText(message);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment("image.png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        javaMailSender.send(helper.getMimeMessage());
    }
}

