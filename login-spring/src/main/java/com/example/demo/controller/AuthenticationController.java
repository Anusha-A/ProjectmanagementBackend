package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.dao.UserDao;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.AuthToken;
import com.example.demo.model.LoginUser;
import com.example.demo.model.User;
import com.example.demo.service.NotificationService;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
Logger log=LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired
   private NotificationService notificationService;
    
    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/generate-token")
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) {
    	try {
    		
     authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    ));
    		
    	 }catch(Exception e) {
    	    	
    	    	return new ApiResponse<>(402, "error",new AuthToken());
    	    	
    	    	}
    	
        final User user = userService.findOne(loginUser.getUsername());
       
        final String token = jwtTokenUtil.generateToken(user);
        
        log.info("A1:  "+token);
        //System.out.println(token);
        final String usertype= user.getUserType().trim();
       log.info("A2: "+usertype);
       final long userId= user.getEmployeeId();
       log.info("A3: "+userId);
       // System.out.print(usertype);
       
       
        if(usertype.equals("admin")||(usertype.equals("ADMIN")))
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUserType(),userId));
        else if(usertype.equals("manager") ||(usertype.equals("MANAGER")))
        	return new ApiResponse<>(202, "success",new AuthToken(token, user.getUserType(),userId));
        else 
        	return new ApiResponse<>(201, "success",new AuthToken(token,user.getUserType(),userId));
   
    }
    
    

	@RequestMapping(value="/send-email")
	public boolean signupSuccess(@RequestBody LoginUser user)
	{
		log.info(user.getUsername());
		User userobj = new User();
		userobj = userDao.findByUsername(user.getUsername());
		System.out.println(userobj);
		
		if(userobj!=null) {
			User user1 = new User();
			user1.setUsername(user.getUsername());
		
			
			
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz"; 

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
	log.info(password);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		log.info("========================================================");
		

		user1.setPassword(password);
		userobj.setPassword(hashedPassword);
		userDao.save(userobj);
			
	try
			{
				notificationService.Sendnotification(user1);
				return true;
				
			}
			catch(MailException e)
			{
				log.info("Error sending email" + e.getMessage());
				return false;
			}
			
			 
		}
		else {
			return false;
		}
	
	}
}