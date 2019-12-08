package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TaskService;
import com.example.demo.entity.Task;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private Environment env;
	@Autowired
	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	private TaskService taskService;
	
	@LoadBalanced
	@GetMapping("/getTasks/{projectId}")
	public List<Task> getTaskByProjectId(@PathVariable long projectId )
	{
		System.out.println(env.getProperty("server.port"));
		return taskService.getTaskByProjectId(projectId);
	}
	
	@LoadBalanced
	@GetMapping("/getTasks")
	public List<Task> getallTasks()
	{
		System.out.println(env.getProperty("server.port"));
		return taskService.getTasks();
	}

}
