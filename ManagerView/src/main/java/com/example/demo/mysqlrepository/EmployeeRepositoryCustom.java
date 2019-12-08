package com.example.demo.mysqlrepository;

import java.util.List;

import com.example.demo.entity.Employee;



public interface EmployeeRepositoryCustom
{
    List<Employee> getAllManagerByAvailability();
    
	List<Employee> getAllMembersByAvailability();


}
