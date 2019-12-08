package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Subtask;


public interface SubtaskDAO 
{

	//public List<Subtask> getAllSubtasks(Long empId);

	public void updateProgress(Long subtaskId, Long progressPercentage, String comment);
	//public void updateProgress(Long subtaskId);

}