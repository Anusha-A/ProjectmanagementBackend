package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



import com.example.demo.composite.ProjectMemberComposite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@SuppressWarnings("serial")

@Entity
@Table(name = "project_member")
@IdClass(ProjectMemberComposite.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ProjectMember implements Serializable
{
	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
    @JoinColumn(name="employee_id")
	private Employee employeeId;
	
	@Id	
	@ManyToOne(fetch = FetchType.LAZY,optional=true,targetEntity = Project.class)
    @JoinColumn(name="project_id")
	private Project projectId;
	
	@Column(name="authority", columnDefinition = "boolean default 1")
	private boolean authority;

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public boolean isAuthority() {
		return authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	
}
