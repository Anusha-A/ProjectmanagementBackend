package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkills;
import com.example.demo.mysqlrepository.EmployeeSkillsRepository;


@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

	
	@Autowired
	private EmployeeSkillsRepository employeeSkillsRepository;
	
	@Override
	public List<Employee> getEmployeesBySkill(String skillName) {
		// TODO Auto-generated method stub
		return employeeSkillsRepository.getEmployeesBySkill(skillName);
	}

	
	@Override
	public List<EmployeeSkills> getEmployeeSkills(Long employeeId) {
		// TODO Auto-generated method stub
		return employeeSkillsRepository.getEmployeeSkills(employeeId);
	}
}
