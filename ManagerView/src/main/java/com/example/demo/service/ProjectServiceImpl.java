package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;
import com.example.demo.mysqlrepository.EmployeeRepository;
import com.example.demo.mysqlrepository.ProjectMemberRepository;
import com.example.demo.mysqlrepository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private NotificationService notificationService;

	@Autowired
	private ProjectMemberRepository projectMemberRepository;
	

	@Transactional
	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		
		//Save the project
		Project projectResult =  projectRepository.save(project);
		if(projectResult!= null) {
			Long a = project.getManagerId().getEmployeeId();		
			//Optional<Employee> E = employeeRepository.findById(a);			
			
			
			//Update manager details in employee
			Optional<Employee> optionalEntity =  employeeRepository.findById(a);
			Employee E = optionalEntity.get();
			E.setAvailability(false);
			Employee M = employeeRepository.save(E);
			
			
			//Save project manager in project member table
			ProjectMember projectMember = new ProjectMember();
			projectMember.setProjectId(projectResult);
			projectMember.setEmployeeId(project.getManagerId());
			projectMember.setAuthority(true);
			projectMemberRepository.saveProjectMember(projectMember);
			
			
			if(M!= null) {
				//Send a mail to the manager
			
				notificationService.sendmail(project.getManagerId().getUsername());
			}
	
		}
		
		return projectResult;
	}



	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	
	@Transactional
	@Override
	public Project getProjectById(Long projectId) {
		// TODO Auto-generated method stub
		Optional<Project> optionalEntity =  projectRepository.findById(projectId);
		Project P = optionalEntity.get();
		return P;
	}



	@Override
	public boolean completeProject(Project project) {
		// TODO Auto-generated method stub
		/*
		Optional<Project> optionalEntity = projectRepository.findById(project.getProjectId());
		Project project1 = optionalEntity.get();
		project1.setCompleted(true);
		*/
		
		//UPDATE THE PROJECT TO COMPLETED
		project.setCompleted(true);
		Project project2 = projectRepository.save(project);
		
		
		//FIND ALL MEMBERS OF THE PROJECT INCLUDING MANAGER
		List<ProjectMember> projectMembersList = projectMemberRepository.findAllByProjectId(project);
		
		//UPDATE PROJECT MEMBER AUTHORITY TO THE PROJECT AS FALSE
		projectMemberRepository.updateAuthority(projectMembersList);
		
		
		//UPDATE THE MEMBER'S AVAILABILITY, EUL_AGGREEMENT AND PASSWORD IN EMPLOYEE TABLE
		for (int i = 0; i < projectMembersList.size(); i++) {
		 
			
				 ProjectMember projectMember = projectMembersList.get(i);
				
				 //Optional<Employee> optionalEntity3 = employeeRepository.findById(projectMember.getEmployeeId().getEmployeeId());
				 //Employee employee = optionalEntity3.get();
				 Employee employee = projectMember.getEmployeeId();
				 employee.setAvailability(true);
				 employee.setEulAgreement(false);
				 employee.setPassword(notificationService.genHashPassword());
				 employeeRepository.save(employee);
	 
	    }
		 
		return true;
	}
	

}
