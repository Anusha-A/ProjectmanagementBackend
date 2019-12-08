package com.example.demo.model;

import java.util.Date;

public class Task 
{
	private Long TaskId;
	
	private Project projectId;

	private String taskTitle;

	private String description;

	private String taskDescription;

	private Date startDate;

	private Date dueDate;

	private Long subTaskCount;

	private Long progress;

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getSubTaskCount() {
		return subTaskCount;
	}

	public void setSubTaskCount(Long subTaskCount) {
		this.subTaskCount = subTaskCount;
	}

	public Long getProgress() {
		return progress;
	}

	public void setProgress(Long progress) {
		this.progress = progress;
	}
	
	public Long getTaskId() {
		return TaskId;
	}

	public void setTaskId(Long taskId) {
		TaskId = taskId;
	}


}
