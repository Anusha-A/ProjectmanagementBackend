package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Subtask;
import com.example.demo.service.SubtaskService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SubtaskController 
{
	@Autowired
	private Environment env;
	
	@Autowired
	private SubtaskService subtaskService;
	
	@LoadBalanced
	@GetMapping("/getsubtasks/{projectId}/{taskId}")
	public List<Subtask> getAllSubtasksProj(@PathVariable (value="projectId") Long projectId, @PathVariable (value="taskId") Long taskId)
	{
		System.out.println(env.getProperty("server.port"));
		return subtaskService.getAllSubtasks(projectId,taskId);
	}
	
	
	
	
}
