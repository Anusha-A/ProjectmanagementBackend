package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Skills;
import com.example.demo.service.SkillsService;
import com.example.demo.service.SkillsServiceImpl;

@RestController
@RequestMapping(value = "/skill")
@CrossOrigin(origins = "*")
public class SkillsController {
	@Autowired
	private Environment env;
	
	@Autowired
	private SkillsService skillsService;
	
	@LoadBalanced
	@GetMapping(value = "/getAllSkills")
	public List<Skills> getAllSkills(){
		System.out.println(env.getProperty("server.port"));
		return skillsService.getAllSkills();
	}

}
