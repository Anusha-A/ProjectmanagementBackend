package com.example.demo.mysqlrepository;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkills;

public interface EmployeeSkillsRepositoryCustom {
	
	List<Employee> getEmployeesBySkill(String skillName);
	List<EmployeeSkills> getEmployeeSkills(Long employeeId);

}
