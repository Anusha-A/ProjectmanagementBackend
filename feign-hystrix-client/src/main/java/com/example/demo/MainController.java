package com.example.demo;

import java.util.Collection;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.AuthToken;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkills;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Project;
import com.example.demo.model.ProjectDescStake;
import com.example.demo.model.ProjectMember;
import com.example.demo.model.Skills;
import com.example.demo.model.Subtask;
import com.example.demo.model.Task;
import com.example.demo.service.SubtaskService;

@RestController
@CrossOrigin("*")
public class MainController
{

	@Autowired
	private IntegrationClient integrationClient;
	
	//==========================Anusha's part===================================
	//==========================================================================
	
	//To get all employees
	@GetMapping(value="/searchEmpData")
	public List<Employee> getAllEmployees()
	{
		return this.integrationClient.getAllEmployees();
	}
	
	
	//To get all employees by fname
	@GetMapping(value="/searchEmpData/{fname}")
	public List<Employee> getEmployeeByName(@PathVariable (value = "fname") String fname)
	{
		return integrationClient.getEmployees(fname);
	}
	
	//**********************************************************************
	
	//To fetch all Project Details
	@GetMapping(value="/getProjectDetails/completed")
	public List<Project> getAllProjectDetails()
	{
		return integrationClient.getProjectDetiails();
	}
	
	
	//To fetch project by id from mysql
	@GetMapping(value = "/getProjectDetails/{sqlId}")
	public List<Project> getProjectByIdSQL(@PathVariable  Long sqlId)
	{
		return this.integrationClient.findProjectByIdSQL(sqlId);
	}
		
	//To fetch project by id from mongo
	@GetMapping(value = "/getProjectDetails/mongodb/{theId}")
	public List<ProjectDescStake> getProjectByIdMongo(@PathVariable (value ="theId") Long theId)
	{
		return this.integrationClient.findProjectByIdMongo(theId);
	}
	
	
	//To get ongoing projects by year
	@GetMapping("/api/OngoingByYear/{theYear}")
	public List<Project> findprojectongoing(@PathVariable Integer theYear)
	{
		return this.integrationClient.findprojectongoing(theYear);
	}
		
	
	//To fetch ongoing projects
	@GetMapping(value = "/getProjectDetails/ongoing")
	public List<Project> getOngoingProjects()
	{
		return integrationClient.getOngoingProjects();
	}
		
	//To fetch completed projects by year
	@GetMapping("/api/CompletedByYear/{theYear}")
	public List<Project> findprojectcompleted(@PathVariable Integer theYear)
	{
		return this.integrationClient.findprojectcompleted(theYear);
	}
		
		
	//To fetch all latest projects
	@GetMapping("/api/getLatest")
	public List<Project> findlatestProject()
	{
		return this.integrationClient.findlatestProject();
	}
		
		
	//To get projects by year
	@GetMapping("/api/getByYear")
	public int[] getProjectByYear()
	{
		return this.integrationClient.getProjectByYear();
	}

	
	@GetMapping("/getProjectDetails")
	public List<Project> getAllProjects()
	{
		return integrationClient.getAllProjects();
	}
	
	//***********************************************************
	
	//To get projectmember details
	@GetMapping(value = "/getProjectMembers/{theId}")
	public List<ProjectMember> getProjectMemebers(@PathVariable (value="theId") Long theId)
	{
		return this.integrationClient.getAllProjectMembers(theId);
	}
	
	
	//*********************************************************************
	
	//To fetch tasks by projectId
	@GetMapping(value ="/getTasksById/{projectId}")
	public List<Task> getTaskByProjectId(@PathVariable (value= "projectId") Long projectId)
	{
		return this.integrationClient.getTaskByProjectId(projectId);
	}
	
	
	//To fetch all the tasks
	@GetMapping(value = "/getAllTasks")
	public List<Task> getAllTasks()
	{
		return this.integrationClient.getAllTasks();
	}
	
	
	//*********************************************************************************
	
	//To fetch all subtaks for a project
	@GetMapping("/getsubtasks/{projectId}/{taskId}")
	public List<Subtask> getAllSubtasksProj(@PathVariable (value = "projectId") Long projectId, @PathVariable (value = "taskId") Long taskId)
	{
		System.out.println("yes");
		return this.integrationClient.getAllSubtasksProj(projectId, taskId);
	}
	
	
	
	//=============================================================================
	//============================================================================
	
	
	//**************************Employee Subtask********************************
	
	//To fetch all subtasks
	@GetMapping(value="/getAllsubtasks/{empId}")
	public List<Subtask> getAllsubtask(@PathVariable (value = "empId") Long empId)
	{
		return this.integrationClient.getAllSubtasks(empId);
	}
	
	@PutMapping("/updateProgress/{subtaskId}/{progressPercentage}/{comment}")
	public void updateProgress(@PathVariable(value = "subtaskId") Long subtaskId, @PathVariable(value = "progressPercentage") Long progressPercentage,
			@PathVariable(value="comment") String comment)
	{
		this.integrationClient.updateProgress(subtaskId, progressPercentage, comment);
	}
	
	
	//*************************Manager's Part****************************************
	
	@GetMapping("/project/getManagersByAvailability")
	public List<Employee> getManagersByAvailability()
	{
		return this.integrationClient.getManagersByAvailability();
	}
	
	
	@GetMapping("/project/getEmployeeByskills/{skillName}")
	public List<Employee> getEmployeeBySkills(@PathVariable (value = "skillName") String skillName)
	{
		return this.integrationClient.getEmployeeBySkills(skillName);
	}
	
	
	@GetMapping("/project/Project")
	public List<Project> getAllProjectsForMgr()
	{
		return this.integrationClient.getAllProjects();
	}
	
	
	@PostMapping("/project/Project")
	public Project saveProject(@RequestBody Project project)
	{
		
		System.out.println("yes");
		return this.integrationClient.saveProject(project);
	}
	
	@GetMapping("/project/getProjectById/{projectId}")
	public Project getProjectById(@PathVariable Long projectId)
	{
		return this.integrationClient.getProjectById(projectId);
	}
	
	
	@PutMapping("/project/CompleteProject")
	public boolean completeProject(@RequestBody Project project)
	{
		return this.integrationClient.completeProject(project);
	}
	
	@PostMapping("/projectDesc/saveProjectDesc")
	public ProjectDescStake saveProjectDesc(@RequestBody ProjectDescStake projectDescStake)
	{
		return this.integrationClient.saveProjectDesc(projectDescStake);
	}
	
	
	@GetMapping("/skill/getAllSkills")
	public List<Skills> getAllSkills()
	{
		return this.integrationClient.getAllSkills();
	}
	
	
	@PostMapping("/task/Task")
	public Task saveTask(@RequestBody Task task)
	{
		return this.integrationClient.saveTask(task);
	}
	
	
	@GetMapping("/task/TaskByProjectId/{projectId}")
	public List<Task> getTaskByProjectIdForMgr(@PathVariable Long projectId)
	{
		return this.integrationClient.getTaskByProjectId(projectId);
	}
	
	
	@PostMapping("/subtask/SubTask")
	public Subtask saveTask(@RequestBody Subtask stask)
	{
		return this.integrationClient.saveTask(stask);
	}
	
	
	@GetMapping("/subtask/SubTaskByTaskId/{ltaskId}")
	public List<Subtask> getSubTasksByTaskId(@PathVariable Long ltaskId)
	{
		return this.integrationClient.getSubTasksByTaskId(ltaskId);
	}
	
	
	@GetMapping(value = "/getEmployeeSkills/{employeeId}")
	public List<EmployeeSkills> getEmployeeSkills(@PathVariable Long employeeId)
	{
		return this.integrationClient.getEmployeeSkills(employeeId);
	}
	
	
	//To get Employees by availability
	@GetMapping( value =  "/getMembersByAvailability")
	public List<Employee> getAllMembers()
	{
		return this.integrationClient.getAllMembers();
	}

	
	//To save project memebr
	@PostMapping(value = "/projectMember/saveProjectMember")
	public void saveProjectMember(@RequestBody ProjectMember projectMember)
	{
		 this.integrationClient.saveProjectMember(projectMember);
	}
	

	//To list all project members
	@GetMapping("/projectMember/getProjectMember")
	public List<ProjectMember> getAll()
	{
		return this.integrationClient.getAll();
	}
	
	
	//To fetch all project members belonging to a project
	@GetMapping("/projectMember/getAllMembersOfAProject/{project}")
	public List<ProjectMember> getAllMembersOfAProject(@PathVariable Long project)
	{
		return this.integrationClient.getAllMembersOfAProject(project);
	}
	
}
