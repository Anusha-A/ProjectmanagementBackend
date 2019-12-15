package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.TaskServiceImpl;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "*")
public class TaskController {
	@Autowired
	private Environment env;
	
	@Autowired
	private TaskService taskService;
	
	@LoadBalanced
	@PostMapping("/Task")
	public Task saveTask(@RequestBody Task task) {	
		System.out.println(env.getProperty("server.port"));
		return taskService.saveTask(task);
	}
	
	@LoadBalanced
	@GetMapping("/TaskByProjectId/{projectId}")
	public List<Task> getProjectById(@PathVariable Long projectId){	
		System.out.println(env.getProperty("server.port"));
		return taskService.getAllTasksByProjectId(projectId);
	}

}
