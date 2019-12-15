package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "subtask")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subtask  
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_task_id")
	private Long subTaskId;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional=true,targetEntity = Task.class)
    @JoinColumn(name="task_id")
	private Task taskId;	
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false,targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	private Employee employeeId;
	
	@Column(name = "sub_task_title")
	private String subTaskTitle;
	
	@Column(name = "sub_task_description")
	private String subTaskDescription;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "progress_percentage",columnDefinition = "bigint default 0")
	private Long progressPercentage;
	
	@Column(name = "comment")
	private String comment;

	public Long getSubTaskId() {
		return subTaskId;
	}



	public Task getTaskId() {
		return taskId;
	}



	public Employee getEmployeeId() {
		return employeeId;
	}

	public String getSubTaskTitle() {
		return subTaskTitle;
	}

	

	public String getSubTaskDescription() {
		return subTaskDescription;
	}



	public Date getStartDate() {
		return startDate;
	}


	public Date getDueDate() {
		return dueDate;
	}

	
	public Long getProgressPercentage() {
		return progressPercentage;
	}

	public void setProgressPercentage(Long progressPercentage) {
		this.progressPercentage = progressPercentage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
