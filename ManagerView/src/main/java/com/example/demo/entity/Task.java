package com.example.demo.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "task")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Task implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5973130101893548599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_Id")
	private Long taskId;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Project.class)
    @JoinColumn(name="project_id")
	private Project projectId;
	
	@Column(name = "task_title")
	private String taskTitle;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "sub_task_count", columnDefinition = "bigint default 0")
	private Long subTaskCount;
	
	@Column(name = "progress", columnDefinition = "bigint default 0")
	private Long progress;
}	
