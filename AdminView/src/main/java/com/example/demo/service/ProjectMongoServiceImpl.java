package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ProjectDescStake;
import com.example.demo.mongorepository.ProjectDescStakeRepository;

@Service
@Transactional
public class ProjectMongoServiceImpl implements ProjectMongoService {
	
	@Autowired
	private ProjectDescStakeRepository projectDescStakeRepository;
	
	@Override
	public List<ProjectDescStake> getProjectDetails(Long theId) {
		// TODO Auto-generated method stub
		return projectDescStakeRepository.findByProjectId(theId);
	}

}
