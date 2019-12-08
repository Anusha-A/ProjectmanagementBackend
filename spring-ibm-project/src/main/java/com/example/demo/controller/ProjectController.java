package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;


@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/getProjects")
	public List<Project> getAll(){		
		return projectRepository.findAll();		
	}
	
	@PostMapping("/saveProject")
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	@PutMapping("/updateProjects/{projectId}")
	public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project postRequest) {
		
		return projectRepository.findById(projectId).map(project -> {
			project.setName(postRequest.getName());
			project.setDescription(postRequest.getDescription());
			project.setStartDate(postRequest.getStartDate());
			project.setEndDate(postRequest.getEndDate());
			project.setStakeholders(postRequest.getStakeholders());
			project.setCompleted(postRequest.isCompleted());
			return projectRepository.save(project);
		}).orElseThrow(() -> new ResourceNotFoundException("Project Id " + projectId + " not found"));
	}
	
	/*
	@DeleteMapping("/deleteProject/{projectId}")
	public Project deleteProject(@PathVariable Long projectId, @Valid @RequestBody Project postRequest) {
		
		return projectRepository.findById(projectId).map(project -> {
			
			projectRepository.delete(project);
			return ResponseEntity.ok().build();
			
		}).orElseThrow(() -> new ResourceNotFoundException("Project Id " + projectId + " not found"));
	}
	*/

}
