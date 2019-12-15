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

import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;
import com.example.demo.service.SubTaskService;
import com.example.demo.service.SubTaskServiceImpl;
import com.example.demo.service.TaskServiceImpl;

@RestController
@RequestMapping(value = "/subtask")
@CrossOrigin(origins = "*")
public class SubTaskController {
	
	@Autowired
	private SubTaskService subtaskService;
	@Autowired
	private Environment env;
	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@LoadBalanced
	@PostMapping("/SubTask")
	public Subtask saveTask(@RequestBody Subtask stask) {	
		System.out.println(env.getProperty("server.port"));
		return subtaskService.saveSubTask(stask);
	}
	
	@LoadBalanced
	@GetMapping("/SubTaskByTaskId/{ltaskId}")
	public List<Subtask> getSubTasksByTaskId(@PathVariable Long ltaskId){
		System.out.println(env.getProperty("server.port"));
		
		Task tt = taskServiceImpl.getTasksById(ltaskId);
		return subtaskService.findByTaskId(tt);
	}

}
