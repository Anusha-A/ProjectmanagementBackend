package com.example.demo.composite;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProjectEmployeeSkillsComposite implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -6413193490142354578L;
	
	private Long employeeId;
	private Long skillId;

}
