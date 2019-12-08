package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubtaskDAO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Subtask;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SubtaskRepository;

@Service
@Transactional
public class SubtaskServiceImpl implements SubtaskService 
{
	/*private SubtaskDAO subtaskdao;
	
	public SubtaskServiceImpl(SubtaskDAO subtaskdao) {
		super();
		this.subtaskdao = subtaskdao;
	}*/
	private SubtaskRepository subTaskRepo;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public SubtaskServiceImpl(SubtaskRepository subTaskRepo) {
		super();
		this.subTaskRepo = subTaskRepo;
	}



	@Override
	public void getAllSubtasks()
	{
		Long empId=1L;
		//Optional<Employee> emp = employeeRepository.findById(empId);
		List<Subtask> subtasks = subTaskRepo.findAll();
		System.out.println(subtasks.toString());
	}

}
