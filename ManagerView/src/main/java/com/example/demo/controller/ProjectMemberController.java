package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;
import com.example.demo.service.ProjectMemberService;
import com.example.demo.service.ProjectMemberServiceImpl;
import com.example.demo.service.ProjectService;
import com.example.demo.service.ProjectServiceImpl;

@RestController
@RequestMapping(value = "/projectMember")
@CrossOrigin(origins = "*")
public class ProjectMemberController {
	
	@Autowired
	private Environment env;
	@Autowired
	private ProjectMemberService projectMemberService;
	
	@Autowired
	private ProjectService projectService;
	
	
	@LoadBalanced
	@PostMapping(value = "/saveProjectMember")
	public void saveProjectMember(@RequestBody ProjectMember projectMember) {	
		System.out.println(env.getProperty("server.port"));
		 projectMemberService.saveProjectMember(projectMember);
	}
	
	@LoadBalanced
	@GetMapping("/getProjectMember")
	public List<ProjectMember> getAll(){
		System.out.println(env.getProperty("server.port"));
		return projectMemberService.getAll();		
	}
	
	@LoadBalanced
	@GetMapping("/getAllMembersOfAProject/{project}")
	public List<ProjectMember> getAllMembersOfAProject(@PathVariable Long project){	
		System.out.println(env.getProperty("server.port"));
		Project p = projectService.getProjectById(project);
		return projectMemberService.getProjectMemberByProjectId(p);
		
	}
	
	
}
