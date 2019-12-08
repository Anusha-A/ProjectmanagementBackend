package com.example.demo.composite;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProjectManagerComposite implements Serializable
{
	
	private Long employeeId;
	
	private Long projectId;
}
