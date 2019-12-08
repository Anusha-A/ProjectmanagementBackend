package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkills;

public interface EmployeeSkillsService {
	
	List<Employee> getEmployeesBySkill(String skillName);
	List<EmployeeSkills> getEmployeeSkills(Long employeeId);

}
