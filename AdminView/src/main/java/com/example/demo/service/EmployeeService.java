package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public List<Employee> findByFirstName(String fname);
	

}
