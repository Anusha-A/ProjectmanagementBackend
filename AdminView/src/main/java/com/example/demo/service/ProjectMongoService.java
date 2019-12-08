package com.example.demo.service;


import java.util.List;


import com.example.demo.model.ProjectDescStake;;
public interface ProjectMongoService {
	public List<ProjectDescStake> getProjectDetails(Long theId);

};
