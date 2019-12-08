package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	private TaskRepository taskRepository;

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	@Transactional
	public List<Task> getTaskByProjectId(long projectId) {
		// TODO Auto-generated method stub
		return taskRepository.getTaskByProjectId(projectId);
	}

}
