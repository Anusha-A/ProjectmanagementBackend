package com.example.demo.model;

import java.util.Date;

public class Subtask 
{
	private Long subTaskId;
	

	private Task taskId;	
	
	
	private Employee employeeId;
	
	
	private String subTaskTitle;
	
	
	private String subTaskDescription;
	
	
	private Date startDate;
	
	
	private Date dueDate;
	
	
	private Long progressPercentage;
	
	private String comment;
	
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}



	public Task getTaskId() {
		return taskId;
	}


	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}


	public Employee getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}


	public String getSubTaskTitle() {
		return subTaskTitle;
	}


	public void setSubTaskTitle(String subTaskTitle) {
		this.subTaskTitle = subTaskTitle;
	}


	public String getSubTaskDescription() {
		return subTaskDescription;
	}


	public void setSubTaskDescription(String subTaskDescription) {
		this.subTaskDescription = subTaskDescription;
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


	public Long getProgressPercentage() {
		return progressPercentage;
	}


	public void setProgressPercentage(Long progressPercentage) {
		this.progressPercentage = progressPercentage;
	}
	
	public Long getSubTaskId() {
		return subTaskId;
	}


	public void setSubTaskId(Long subTaskId) {
		this.subTaskId = subTaskId;
	}
}
