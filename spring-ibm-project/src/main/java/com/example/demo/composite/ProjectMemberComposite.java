package com.example.demo.composite;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProjectMemberComposite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4373479559474913451L;

	private Long employeeId;
	
	private Long projectId;

}
