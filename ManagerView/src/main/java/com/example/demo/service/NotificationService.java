package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Employee;
import com.example.demo.mysqlrepository.EmployeeRepository;

@Service
public class NotificationService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public String genHashPassword() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(8); 

		for (int i = 0; i < 8; i++) { 
			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index = (int)(AlphaNumericString.length() * Math.random()); 
			
			// add Character one by one in end of sb 
			sb.append(AlphaNumericString.charAt(index)); 
		}
		String password =sb.toString(); 
		System.out.println(password);
		
		//String passwordEncoder = password;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		//String hashedPassword = passwordEncoder;
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
		
		return hashedPassword;
		
	}
	
	public boolean sendmail(String email) {
		
		Employee userobj = employeeRepository.findByUsername(email);
		
		System.out.println(userobj);
		
		if(userobj!=null) {	
			
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 

			// create StringBuffer size of AlphaNumericString 
			StringBuilder sb = new StringBuilder(10); 

			for (int i = 0; i < 10; i++) { 
				// generate a random number between 
				// 0 to AlphaNumericString variable length 
				int index = (int)(AlphaNumericString.length() * Math.random()); 
				
				// add Character one by one in end of sb 
				sb.append(AlphaNumericString.charAt(index)); 
			} 
		
			String password =sb.toString(); 
			System.out.println(password);
			
			//String passwordEncoder = password;
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			//String hashedPassword = passwordEncoder;
			String hashedPassword = passwordEncoder.encode(password);
			System.out.println(hashedPassword);
			
			userobj.setPassword(hashedPassword);
			employeeRepository.save(userobj);
			
			try
			{
				//System.out.println(userobj.getFirstName()+" "+password);
				
				
				Sendnotification(userobj, password);
				return true;
				
			}
			catch(MailException e)
			{
				System.out.println("Error sending email" + e.getMessage());
				return false;
			}
			
			 
		}
		else {
			return false;
		}
		
		
		
	}
	
	public void Sendnotification(Employee user, String password) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getUsername());
		mail.setFrom("projectmng789syst@gmail.com");
		mail.setSubject("Project Password");
		mail.setText("Hi "+ user.getFirstName()
				+ "\n\nYou have been assigned with a new project"
				+ " \n\nPlease login to the  website using the given credentials.\n\nYour login qualifications are as per the following:\nUsername: " +
				user.getUsername() + "\nPassword: "+ password);
		
		javaMailSender.send(mail);
	}
	
	
	public void SendSubTasknotification(Employee user) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getUsername());
		mail.setFrom("projectmng789syst@gmail.com");
		mail.setSubject("A new task assigned");
		mail.setText("Hi "+ user.getFirstName()
				+ "\n\nYou have been assigned with a new task"
				+ " \n\nPlease login to the  website using the credentials and complete it within the duedate.");
		
		javaMailSender.send(mail);
	}


}
