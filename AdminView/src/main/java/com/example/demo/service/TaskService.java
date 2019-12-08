package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Task;
public interface TaskService {
	public List<Task> getTasks();
	public List<Task> getTaskByProjectId(long projectId);

}
