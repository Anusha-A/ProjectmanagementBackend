package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ProjectMember;

public interface ProjectMemberRepositoryCustom {
	public List<ProjectMember> getByEmpId(long theId);
	public List<ProjectMember> getEmpProject(Long theId);
	

}
