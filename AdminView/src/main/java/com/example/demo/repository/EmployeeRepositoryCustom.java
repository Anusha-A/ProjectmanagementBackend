package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeRepositoryCustom {
	public List<Employee> findEmp(String value);
	public List<Employee> findAllEmp();

}
