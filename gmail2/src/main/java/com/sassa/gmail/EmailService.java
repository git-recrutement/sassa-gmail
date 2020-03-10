package com.sassa.gmail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:MM");


    public void sendSimpleMessage(String to, String subject, String htmlMsg) throws MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        emailSender.send(mimeMessage);

    }

    @Scheduled(cron="0 0 * * * *")
    public void doSomething() throws MessagingException{
        // this will execute on weekdays
        sendSimpleMessage("dinfojavaweb@protonmail.com","test htm","hello"+
                simpleDateFormat.format(new Date()) );
    }


}
