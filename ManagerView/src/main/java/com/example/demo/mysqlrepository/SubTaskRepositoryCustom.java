package com.example.demo.mysqlrepository;

import java.util.List;

import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;

public interface SubTaskRepositoryCustom {
	
	List<Subtask> getAllSubTasksByTaskId(Task task);

}
