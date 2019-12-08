package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;



@Service
public class NotificationService 
{
	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) 
	{
		super();
		this.javaMailSender = javaMailSender;
	}
	
	public void Sendnotification(User user) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getUsername());
		mail.setFrom("projectmng789syst@gmail.com");
		mail.setSubject("Project Password");
		mail.setText("Hi Please login using the given credentials.\n\nYour login qualifications are as per the following:\nUsername: " +
				user.getUsername() + "\nPassword: "+ user.getPassword());
		
		javaMailSender.send(mail);
	}
	

	
	
}