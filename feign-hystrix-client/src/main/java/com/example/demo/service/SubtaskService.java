package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Subtask;


@FeignClient("project-management")
public interface SubtaskService 
{
	
	//To access all subtasks for a given employee based on his id.
	@GetMapping("/api/getsubtasks/{empId}")
	public List<Subtask> getAllSubtasks(@PathVariable (value = "empId") Long empId);
		
	@PutMapping("/api/updateProgress/{subtaskId}/{progressPercentage}/{comment}")
	public void updateProgress(@PathVariable(value = "subtaskId") Long subtaskId, @PathVariable(value = "progressPercentage") Long progressPercentage,
			@PathVariable(value="comment") String comment);

}
