package com.example.demo.mysqlrepository;


import java.util.List;

import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;

public interface ProjectMemberRepositoryCustom {

	public void saveProjectMember(ProjectMember projectMember);
	public List<ProjectMember> getProjectMemberByProjectId(Project project);
	public void updateAuthority(List<ProjectMember> projectMembersList);



}
