package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	
	private EmployeeRepository empRepo;
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}