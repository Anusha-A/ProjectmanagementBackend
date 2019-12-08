package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeSkills;
import com.example.demo.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {
	@Autowired
	private EmployeeSkillsRepository employeeSkillsRepository;

	@Override
	public List<EmployeeSkills> getEmployeeSkills(Long theId) {
		// TODO Auto-generated method stub
		return employeeSkillsRepository.getEmployeeSkills(theId);
	}

}
