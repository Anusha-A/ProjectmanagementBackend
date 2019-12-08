package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Project;

public interface ProjectService {
	
	public Project saveProject(Project project);
	public List<Project> getAll();
	public Project getProjectById(Long projectId);
	public boolean completeProject(Project project);

}
