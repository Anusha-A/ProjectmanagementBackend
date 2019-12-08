package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Project;

public interface ProjectService {
	public List<Project> getCompletedProjects();
	public List<Project> getOngoingProjects();
	public List<Project> getById(long theId);
	public List<Project> getByOngoingProjectYear(Integer theYear);
	public List<Project> getCompletedProjectYear(Integer theYear);
	public List<Project> getAllProjects();
	public List<Project> getlatestProject();
	
	public int[] getByProjectYear();
}
