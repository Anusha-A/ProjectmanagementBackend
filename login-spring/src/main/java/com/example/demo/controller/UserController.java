package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.AuthToken;
import com.example.demo.model.LoginUser;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
Logger log=LoggerFactory.getLogger(AuthenticationController.class);
   
  
    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }


    @RequestMapping(value="/agreement")
    public ApiResponse<AuthToken> agreementcheck(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	final User user = userService.findOne(loginUser.getUsername());
        final boolean agree= user.isEulAgreement();
        log.info("=================================================");
        log.info(""+agree);
        final long userId=  user.getEmployeeId();
        if(agree) {
        	 log.info("trueeeeee"+agree);
 return new ApiResponse<>(200, "Agreed",userId);
        }
        else{
        	 return new ApiResponse<>(201, "Disagreed",userId);
        }
        
	
    	
    }
    


}