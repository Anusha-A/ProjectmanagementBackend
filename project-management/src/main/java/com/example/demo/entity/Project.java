package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")

@NoArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Project implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;
	
	@NotNull
	@Column(name = "project_name")
	private String name;
	
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull
	@Column(name = "end_date")
	private Date endDate;
	
	@NotNull
	@Column(name="githubLink")
	private String githubLink;
	
	@NotNull
	@Column(name="budget")
	private Long budget;
	
	@NotNull
	@Column(name = "is_completed", columnDefinition = "boolean default 0")
	private boolean isCompleted;
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
    @JoinColumn(name="manager_id")
	private Employee managerId;

	public Long getProjectId() {
		return projectId;
	}


	public String getName() {
		return name;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Date getEndDate() {
		return endDate;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public Long getBudget() {
		return budget;
	}

	

	public boolean isCompleted() {
		return isCompleted;
	}

	public Employee getManagerId() {
		return managerId;
	}

	
}
