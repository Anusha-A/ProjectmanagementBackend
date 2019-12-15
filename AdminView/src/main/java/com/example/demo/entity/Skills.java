package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;




@Entity
@Table(name = "skills")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Skills implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6426262112728330847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skill_id")
	private Long skill_id;
	
    @Column(name="skill_name")
	private String skill_name;

	public Long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
    
}
