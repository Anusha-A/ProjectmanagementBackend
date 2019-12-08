package com.example.demo.service;

import java.util.List;


import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.EmployeeSkills;
import com.example.demo.model.ProjectMember;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.model.ProjectDescStake;
import com.example.demo.model.Skills;
import com.example.demo.model.Subtask;
import com.example.demo.model.Task;

@FeignClient("manager-view")
public interface ManagerService 
{
	
	//Getting managers By Availability
	@GetMapping("/employee/getManagersByAvailability")
	public List<Employee> getManagersByAvailability();
	
	
	//To get employees by skills
	@GetMapping("/employeeSkill/getEmployeesBySkills/{skillName}")
	public List<Employee> getEmployeeBySkills(@PathVariable String skillName);
	
	
	//To fetch all projects
	@GetMapping("/project/Project")
	public List<Project> getAllProjects();
	
	
	//To save the project
	@PostMapping("/project/Project")
	public Project saveProject(@RequestBody Project project);
	
	
	//To get Project by id
	@GetMapping("/project/ProjectById/{projectId}")
	public Project getProjectById(@PathVariable Long projectId);
	
	
	//To update completed projects
	@PutMapping("/project/CompleteProject")
	public boolean completeProject(@RequestBody Project project);
	
	
	//To save Project Description and Stakeholders on MongoDb
	@PostMapping("/projectDesc/saveProjectDesc")
	public ProjectDescStake saveProjectDesc(@RequestBody ProjectDescStake projectDescStake);
	
	
	
	//To get all skills
	@GetMapping("/skill/getAllSkills")
	public List<Skills> getAllSkills();
	
	
	
	//To save the task
	@PostMapping("/task/Task")
	public Task saveTask(@RequestBody Task task);
	
	
	//To get task by id
	@GetMapping("/task/TaskByProjectId/{projectId}")
	public List<Task> getTaskByProjectId(@PathVariable Long projectId);
	
	
	//To save the subtask
	@PostMapping("/subtask/SubTask")
	public Subtask saveTask(@RequestBody Subtask stask);
	
	
	//To find subtask by id
	@GetMapping("/subtask/SubTaskByTaskId/{ltaskId}")
	public List<Subtask> getSubTasksByTaskId(@PathVariable Long ltaskId);
	
	
	
	//To find employee Skills
	@GetMapping(value = "/getEmployeeSkills/{employeeId}")
	public List<EmployeeSkills> getEmployeeSkills(@PathVariable Long employeeId);
	
	
	//To get Employees by availability
	@GetMapping( value =  "/getMembersByAvailability")
	public List<Employee> getAllMembers();
	
	
	@PostMapping(value = "/projectMember/saveProjectMember")
	public void saveProjectMember(@RequestBody ProjectMember projectMember);
	

	@GetMapping("/projectMember/getProjectMember")
	public List<ProjectMember> getAll();
	
	
	@GetMapping("/projectMember/getAllMembersOfAProject/{project}")
	public List<ProjectMember> getAllMembersOfAProject(@PathVariable Long project);
	
}
