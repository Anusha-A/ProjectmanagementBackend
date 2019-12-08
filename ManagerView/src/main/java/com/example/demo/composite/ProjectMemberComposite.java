package com.example.demo.composite;


import java.io.Serializable;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ProjectMemberComposite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4373479559474913451L;

	private Employee employeeId;
	
	private Project projectId;

}
