package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subtask;

public interface SubtaskService 
{
	public List<Subtask> getAllSubtasks(long projectId,long taskId);
}
