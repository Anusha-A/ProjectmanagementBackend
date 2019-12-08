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
import javax.validation.constraints.NotNull;

import com.example.demo.composite.ProjectMemberComposite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "project_member")
@IdClass(ProjectMemberComposite.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ProjectMember implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2487220607231017773L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
    @JoinColumn(name="employee_id")
	private Employee employeeId;
	
	@Id	
	@ManyToOne(fetch = FetchType.LAZY,optional=true,targetEntity = Project.class)
    @JoinColumn(name="project_id")
	private Project projectId;
	
	@NotNull
	@Column(name = "authority", columnDefinition="boolean default 1")
	private boolean authority;
}
