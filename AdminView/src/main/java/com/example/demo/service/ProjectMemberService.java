package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.ProjectMember;

public interface ProjectMemberService {
	
	public List<ProjectMember> getByEmpId(long theId);
	    
	public List<ProjectMember> getAllProjectEmployee(Long theId);      
	  

}
