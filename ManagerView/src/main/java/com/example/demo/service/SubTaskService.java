package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;

public interface SubTaskService {
	
	List<Subtask> findByTaskId(Task task);
	Subtask saveSubTask(Subtask subTask);

}
