package com.example.demo.entity;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "project")
@Getter
@Setter
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;
	
	@NotNull
	@Column(name = "project_name")
	private String name;
	
	@Lob
	@NotNull
	@Column(name = "project_desc", columnDefinition = "CLOB")
	private Clob description;
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull
	@Column(name = "end_date")
	private Date endDate;
	
	@Lob
	@Column(name = "stakeholders", columnDefinition = "CLOB")
	private Clob stakeholders;
	
	@NotNull
	@Column(name = "is_completed", columnDefinition = "boolean default 0")
	private boolean isCompleted;
	
	
}
