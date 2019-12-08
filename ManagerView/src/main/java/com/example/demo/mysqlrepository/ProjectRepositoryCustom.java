package com.example.demo.mysqlrepository;

import java.util.List;

import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;

public interface ProjectRepositoryCustom
{
    
	public List<ProjectMember> completeProject(Project project) ;
}
