package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subtask;

public interface SubtaskService 
{
	public List<Subtask> getAllSubtasks(Long empId);

	public void updateProgress(Long subtaskId, Long progressPercentage, String comment);
	//public void updateProgress(Long subtaskId);
}

