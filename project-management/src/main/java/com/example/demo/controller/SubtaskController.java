package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Subtask;
import com.example.demo.service.SubtaskService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SubtaskController 
{
	@Autowired
	private Environment env;
	
	@Autowired
	private SubtaskService subtaskService;
	
	
	@LoadBalanced
	@GetMapping("/getsubtasks/{empId}")
	@ResponseBody
	public List<Subtask> getAllSubtasks(@PathVariable Long empId) 
	{
		System.out.println(env.getProperty("server.port"));
		return subtaskService.getAllSubtasks(empId);
	}

	
	@LoadBalanced
	@PutMapping("/updateProgress/{subtaskId}/{progressPercentage}/{comment}")
	public void updateProgress(@PathVariable(value = "subtaskId") Long subtaskId, @PathVariable(value = "progressPercentage") Long progressPercentage, @PathVariable(value="comment") String comment) 
	{
		System.out.println(env.getProperty("server.port"));

		subtaskService.updateProgress(subtaskId, progressPercentage, comment);
		
	}
	
	
}