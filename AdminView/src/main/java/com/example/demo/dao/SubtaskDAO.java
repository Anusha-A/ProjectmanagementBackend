package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Subtask;

public interface SubtaskDAO 
{

	public List<Subtask> getAllSubtasks(long projectId,long taskId);

}
