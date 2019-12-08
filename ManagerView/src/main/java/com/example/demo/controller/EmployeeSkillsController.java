package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkills;
import com.example.demo.service.EmployeeSkillsServiceImpl;

@RestController
@RequestMapping(value = "/employeeSkill")
@CrossOrigin(origins = "*")
public class EmployeeSkillsController {
	@Autowired
	private Environment env;
	@Autowired
	private EmployeeSkillsServiceImpl employeeSkillServiceImpl;
	
	@LoadBalanced
	@GetMapping(value = "/getEmployeesBySkills/{skillName}")
	public List<Employee> getEmployeesBySkills(@PathVariable String skillName){
		
		System.out.println(env.getProperty("server.port"));
		return employeeSkillServiceImpl.getEmployeesBySkill(skillName);
		
		
	}
	@LoadBalanced
	@GetMapping(value = "/getEmployeeSkills/{employeeId}")
	public List<EmployeeSkills> getEmployeeSkills(@PathVariable Long employeeId){
		System.out.println(env.getProperty("server.port"));
		return employeeSkillServiceImpl.getEmployeeSkills(employeeId);	
		
	}
	

}
