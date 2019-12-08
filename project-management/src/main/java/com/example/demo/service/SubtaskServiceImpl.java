package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubtaskDAO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Subtask;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SubTaskRepository;

@Service
@Transactional
public class SubtaskServiceImpl implements SubtaskService {
	@Autowired
	private SubtaskDAO subtaskdao;

	@Autowired
	private SubTaskRepository subtaskRepo;

	@Autowired
	private EmployeeRepository empRepo;

	public SubtaskServiceImpl(SubTaskRepository subtaskRepo, EmployeeRepository empRepo) 
	{
		super();
		this.subtaskRepo = subtaskRepo;
		this.empRepo = empRepo;
	}
	
	
	

	@Override
	public List<Subtask> getAllSubtasks(Long empId) {
		//return subtaskdao.getAllSubtasks(empId);
		List<Subtask> selected = new ArrayList<Subtask>();
		Long id = 2L;
		Optional<Employee> emp = empRepo.findById(empId);

		System.out.println(emp);
		List<Subtask> subs = subtaskRepo.findByEmployeeId(emp);
		for (Subtask sub : subs) {
			if (!sub.getProgressPercentage().equals(100)) {
				selected.add(sub);
			}

		}
		System.out.println(selected);
		return selected;
		
	}

	
	
	
	
	@Override
	public void updateProgress(Long subtaskId, Long progressPercentage, String comment) {
		// TODO Auto-generated method stub
		subtaskdao.updateProgress(subtaskId, progressPercentage, comment);
	}
	
	/*@Override
	public void updateProgress(Long subtaskId) {
		// TODO Auto-generated method stub
		subtaskdao.updateProgress(subtaskId);
	}*/


	

}