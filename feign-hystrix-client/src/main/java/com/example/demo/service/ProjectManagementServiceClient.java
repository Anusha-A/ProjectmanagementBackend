package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.IntegrationClient;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.model.ProjectDescStake;
import com.example.demo.model.ProjectMember;
import com.example.demo.model.Subtask;
import com.example.demo.model.Task;

@FeignClient("admin-view")
public interface ProjectManagementServiceClient
{

	
	//Seraching an employee
	@GetMapping("/api/search")
	public List<Employee> getAll();
		
	
	//access employee data
	@GetMapping("/api/search/{fname}")
	public List<Employee> getData(@PathVariable String fname);
	
	//*****************************************************************************
	
	// access project table
	@GetMapping("/api/getProjects/completed")
	public List<Project> getCompletedProjects();
	
	
	@GetMapping("/api/getProjects/ongoing")
	public List<Project> getOngoingProjects();
	
	//get data from mysql
	@GetMapping("/api/getProjects/{theId}")
	public List<Project> findById(@PathVariable("theId") Long theId);
	
	
	//access ProjectDesc table from mongodb
	//get data from mongodb
	@GetMapping("/api/getProjects/mongodb/{theId}")
	public List<ProjectDescStake> findByProjId(@PathVariable Long theId);	
	

	//To find ongoing project
		@GetMapping("/api/OngoingByYear/{theYear}")
		public List<Project> findprojectongoing(@PathVariable Integer theYear);
		
		
		//To get completed projects by year
		@GetMapping("/api/CompletedByYear/{theYear}")
		public List<Project> findprojectcompleted(@PathVariable Integer theYear);
		
		
		
		//To get the latest projects
		@GetMapping("/api/getLatest")
		public List<Project> findlatestProject();
		
		
		//To get projects by year
		@GetMapping("/api/getByYear")
		public int[] getProjectByYear();
		
		
		//To fetch all projects
		@GetMapping("/api/getProjects")
		public List<Project> getAllProjects();
		
	
	//************************************************************************************
	
	//access Subtask database
	
		
	@GetMapping("/api/getsubtasks/{projectId}/{taskId}")
	public List<Subtask> getAllSubtasksProj(@PathVariable Long projectId, @PathVariable Long taskId);
	
	
	//****************************TASK*******************************
	
	//access task table
	@GetMapping("/api/getTasks/{projectId}")
	public List<Task> getTaskByProjectId(@PathVariable long projectId );
	
	@GetMapping("/api/getTasks")
	public List<Task> getallTasks();
	
	//***************************PROJECT MEMBERS******************************************

	//fetch data from Project Member table
	@GetMapping("/api/getteams/{theid}")
	public List<ProjectMember> getAllProjectMember(@PathVariable Long theid );
	
	
	
}
