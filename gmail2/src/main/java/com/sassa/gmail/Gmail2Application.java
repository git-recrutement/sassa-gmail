package com.sassa.gmail;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Gmail2Application implements CommandLineRunner {


    @Autowired
    EmailService emailService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:MM");
	
	public static void main(String[] args) {
		SpringApplication.run(Gmail2Application.class, args);
	}
	
	
	@Override
    public void run(String... args) throws Exception {

        emailService.sendSimpleMessage("dinfojavaweb@protonmail.com","test htm","demarré le "+
                simpleDateFormat.format(new Date()) );
    
    }
	

}
