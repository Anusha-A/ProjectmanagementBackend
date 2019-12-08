package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;
import com.example.demo.mysqlrepository.EmployeeRepository;
import com.example.demo.mysqlrepository.ProjectMemberRepository;

@Service
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
	
	@Autowired
	private ProjectMemberRepository projectMemberRepository;
	

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private NotificationService notificationService;
	
	@Override
	public void saveProjectMember(ProjectMember projectMember) {		
		 	projectMemberRepository.saveProjectMember(projectMember);
		 
		 
		 	Employee E = projectMember.getEmployeeId();		
			//Optional<Employee> E = employeeRepository.findById(a);			
			E.setAvailability(false);
			employeeRepository.save(E);
			
			//Send mail to the employee
			notificationService.sendmail(projectMember.getEmployeeId().getUsername());
			
	}
	
	
	@Override	
	public List<ProjectMember> getAll() {		
		 return projectMemberRepository.findAll();
	}


	@Override
	public List<ProjectMember> getProjectMemberByProjectId(Project project) {
		// TODO Auto-generated method stub
		return projectMemberRepository.getProjectMemberByProjectId(project);
	}

}
