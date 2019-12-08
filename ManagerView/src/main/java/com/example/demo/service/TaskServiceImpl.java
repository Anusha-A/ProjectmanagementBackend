package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.mysqlrepository.TaskRepository;
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> getAllTasksByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		return taskRepository.getAllTasksByProjectId(projectId);
	}

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	
	public Task getTasksById(Long taskId) {
		// TODO Auto-generated method stub
		Optional<Task>  optionalEntity = taskRepository.findById(taskId);
		Task T = optionalEntity.get();
		return T;
	}
}
