package com.example.demo.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEmployeessTest()
	{
		
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(new Employee(1L,"fname1","mname1","lname1","MANAGER","kokkarneakshatha@gmail.com","12345678",true,false));
		when(employeeRepository.findAll()).thenReturn(employees);
		
		List<Employee> result = employeeService.getAll();
		assertEquals(1, result.size());
	}
}

