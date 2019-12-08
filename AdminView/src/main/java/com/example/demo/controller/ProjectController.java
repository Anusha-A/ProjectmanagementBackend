package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Project;
import com.example.demo.model.ProjectDescStake;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectMongoService;
import com.example.demo.service.ProjectService;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	private Environment env;
	@Autowired
	private ProjectMongoService projectMongoService;
	
	@Autowired
	private ProjectService projectService;
	
	
	//TO fetch all project details
	@LoadBalanced
	@GetMapping("/getProjects")
	public List<Project> getAllProjects(){	
		System.out.println(env.getProperty("server.port"));
		return projectService.getAllProjects();
	}
	
	
	//To fetch completed project details
	@LoadBalanced
	@GetMapping("/getProjects/completed")
	public List<Project> getCompletedProjects(){	
		System.out.println(env.getProperty("server.port"));
		return projectService.getCompletedProjects();	
	}
	
	
	//TO fetch ongoing project details 
	@LoadBalanced
	@GetMapping("/getProjects/ongoing")
	public List<Project> getOngoingProjects(){	
		System.out.println(env.getProperty("server.port"));
		return projectService.getOngoingProjects();	
	}
	
	 //get data from mysql
	//TO fetch all project details by id
	@LoadBalanced
	@GetMapping("/getProjects/{theId}")
	public List<Project> findById(@PathVariable Long theId)
	{
		System.out.println(env.getProperty("server.port"));
		return projectService.getById(theId);
	}
	
	
	//TO fetch ongoing project details by year
	@LoadBalanced
	@GetMapping("/OngoingByYear/{theYear}")
	public List<Project> findprojectongoing(@PathVariable Integer theYear)
	{
		System.out.println(env.getProperty("server.port"));
		return projectService.getByOngoingProjectYear(theYear);
	}
	
	
	//TO fetch completed project details by year
	@LoadBalanced
	@GetMapping("/CompletedByYear/{theYear}")
	public List<Project> findprojectcompleted(@PathVariable Integer theYear)
	{
		System.out.println(env.getProperty("server.port"));
		return projectService.getCompletedProjectYear(theYear);
	}
	
	//get data from mongo
	@LoadBalanced
	@GetMapping("/getProjects/mongodb/{theId}")
	public List<ProjectDescStake> findByProjId(@PathVariable Long theId)
	{
		System.out.println(env.getProperty("server.port"));
		return projectMongoService.getProjectDetails(theId);
	}
	
	
	//TO fetch all latest project details for the last 5 years
	@LoadBalanced
	@GetMapping("/getLatest")
	public List<Project> findlatestProject()
	{
		System.out.println(env.getProperty("server.port"));
		return projectService.getlatestProject();
	}
	
	
	//To fetch project details by year
	@LoadBalanced
	@GetMapping("/getByYear")
	public int[] getProjectByYear()
	{
		System.out.println(env.getProperty("server.port"));
		return projectService.getByProjectYear();
	}
	
	
}

