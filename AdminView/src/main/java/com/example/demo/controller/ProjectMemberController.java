package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProjectMember;
import com.example.demo.repository.ProjectMemberRepository;
import com.example.demo.service.ProjectMemberService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProjectMemberController {
	@Autowired
	private Environment env;
	@Autowired
	private ProjectMemberService projectMemberService ;
	
	@LoadBalanced
	@GetMapping("/getteams/{theid}")
	public List<ProjectMember> getAllProjectMember(@PathVariable Long theid )
	{
		System.out.println(env.getProperty("server.port"));
		return projectMemberService.getByEmpId(theid);
	}
	
	@LoadBalanced
	@GetMapping("/getmember/{theId}")
	public List<ProjectMember> getProjectMember(@PathVariable Long theId )
	{
		System.out.println(env.getProperty("server.port"));
		return projectMemberService.getAllProjectEmployee(theId);
	}
	
	

}
