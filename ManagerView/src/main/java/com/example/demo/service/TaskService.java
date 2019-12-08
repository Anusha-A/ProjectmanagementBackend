package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Task;

public interface TaskService {
	
	public List<Task> getAllTasksByProjectId(Long projectId);
	public Task saveTask(Task task);

}
