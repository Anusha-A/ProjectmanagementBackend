package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllManagerByAvailability();
	List<Employee> getAllMembersByAvailability();
 Employee getEmployeeById(Long employeeId);
	

	Employee updateEmployeeEul(Employee employee);

}
