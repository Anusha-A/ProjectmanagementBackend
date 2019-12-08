package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Task;
public interface TaskRepositoryCustom {
	public List<Task> getTaskByProjectId(long projectId); 

}
