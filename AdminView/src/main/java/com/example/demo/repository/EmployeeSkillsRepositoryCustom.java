package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.EmployeeSkills;

public interface EmployeeSkillsRepositoryCustom {
	List<EmployeeSkills> getEmployeeSkills(Long theId);

}
