package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.mysqlrepository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;


@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*")

public class EmployeeController {
	@Autowired
	private Environment env;
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@LoadBalanced
	@GetMapping( value =  "/getManagersByAvailability")
	public List<Employee> getAll(){		
		System.out.println(env.getProperty("server.port"));
        return employeeServiceImpl.getAllManagerByAvailability();
	}
	
	@LoadBalanced
	@GetMapping( value =  "/getMembersByAvailability")
	public List<Employee> getAllMembers(){	
		System.out.println(env.getProperty("server.port"));
        return employeeServiceImpl.getAllMembersByAvailability();
	}
	
	@LoadBalanced
	@GetMapping("/EmployeeById/{employeeId}")
	public Employee getEmployeeById(@PathVariable Long employeeId) {
		System.out.println(env.getProperty("server.port"));
		return employeeServiceImpl.getEmployeeById(employeeId);
		
		
	}
	
	@LoadBalanced
	@PutMapping("/updateEul")
	public Employee updateEmployeeEul(@RequestBody Employee employee) {
		System.out.println(env.getProperty("server.port"));
		return employeeServiceImpl.updateEmployeeEul(employee);
	}
	
	

}
