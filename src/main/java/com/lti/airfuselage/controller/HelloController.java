package com.lti.airfuselage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.model.User;

@RestController
public class HelloController {
	@Autowired
	private MailSender mailSender;
	
	//User user=new User();
	@CrossOrigin
	@RequestMapping("/hello")
	public String hello(@RequestBody User user) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("airfuselage@gmail.com");
		message.setTo(user.getEmail());
		message.setSubject("Welcome to Air Fuselage");
		message.setText("Congratulations you have been successfully registered with Air Fuselage");
		mailSender.send(message);
		
		return "Welcome to Spring REST";
	}
}

