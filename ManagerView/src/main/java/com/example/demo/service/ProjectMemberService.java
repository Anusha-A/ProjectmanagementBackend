package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;

public interface ProjectMemberService {
	
	public void saveProjectMember(ProjectMember projectMember) ;	
	public List<ProjectMember> getAll();
	public List<ProjectMember> getProjectMemberByProjectId(Project project);

	
}
