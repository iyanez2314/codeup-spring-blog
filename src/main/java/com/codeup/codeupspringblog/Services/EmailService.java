package com.codeup.codeupspringblog.Services;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

<<<<<<< Updated upstream
    public void prepareAndSend(Post post) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(post.getTitle());
        msg.setText(post.getBody());

        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
=======
    public void prepareAndSend(String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("isaac231467@icloud.com");
        msg.setSubject(subject);
        msg.setText(body);
        try{
            this.emailSender.send(msg);
            System.out.println("email sent");
        } catch (MailException ex){
>>>>>>> Stashed changes
            System.err.println(ex.getMessage());
        }
    }
}
