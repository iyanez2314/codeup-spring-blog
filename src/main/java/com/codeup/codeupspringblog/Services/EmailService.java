package com.codeup.codeupspringblog.Services;


import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("isaac231467@icloud.com");
        msg.setSubject(post.getTitle());
        msg.setText(post.getBody());
        try{
            this.emailSender.send(msg);
        } catch (MailException ex){
            System.err.println(ex.getMessage());
        }
    }
}
