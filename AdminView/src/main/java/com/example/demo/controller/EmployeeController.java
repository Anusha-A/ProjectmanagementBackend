package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkills;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeSkillsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Environment env;
	@Autowired
	private EmployeeSkillsService employeeSkillsService;
	
	@LoadBalanced
	@GetMapping("/search")
	public List<Employee> getAll()
	{
		System.out.println(env.getProperty("server.port"));
		List<Employee> ch= employeeService.getAllEmployee();
		System.out.println(ch);
		return ch;
	}
	
	@LoadBalanced
	@GetMapping("/search/{fname}")
	public List<Employee> getData(@PathVariable String fname)
	{
		System.out.println(env.getProperty("server.port"));
		List<Employee> ch= employeeService.findByFirstName(fname);
		System.out.println(ch);
		return ch;
	}
	
	

}
