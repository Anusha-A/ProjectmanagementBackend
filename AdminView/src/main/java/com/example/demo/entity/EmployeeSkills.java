package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.composite.ProjectEmployeeSkillsComposite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_skills")
@IdClass(ProjectEmployeeSkillsComposite.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class EmployeeSkills implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -317239685787930562L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	private Employee employeeId;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Skills.class)
	@JoinColumn(name = "skill_id")
	private Skills skillId;

}