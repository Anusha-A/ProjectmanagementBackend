package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ProjectDao;
import com.example.demo.entity.Project;
import com.example.demo.mongorepository.ProjectDescStakeRepository;
import com.example.demo.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}
	private ProjectRepository projectRepository;
	
	
	@Override
	@Transactional
	public List<Project> getCompletedProjects() {
		// TODO Auto-generated method stub
		return projectRepository.getAllCompletedProjects();
	}
	@Override
	@Transactional
	public List<Project> getOngoingProjects() {
		// TODO Auto-generated method stub
		return projectRepository.getAllOngingProjects();
	}
	@Override
	public List<Project> getById(long theId) {
		// TODO Auto-generated method stub
		return projectRepository.getprojectById(theId);
		//return projectDescStakeRepository.findByProjectId(theId);
	}
	@Override
	public List<Project> getByOngoingProjectYear(Integer theYear) {
		// TODO Auto-generated method stub
		return projectRepository.findOngoingProjectByYear(theYear);
	}
	@Override
	public List<Project> getCompletedProjectYear(Integer theYear) {
		// TODO Auto-generated method stub
		return projectRepository.findCompletedProjectByYear(theYear);
	}
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAllByOrderByStartDateAsc();
	}
	@Override
	public List<Project> getlatestProject() {
		// TODO Auto-generated method stub
		return projectRepository.getLatestProjects();
	}
	@Override
	public int[] getByProjectYear() 
	{
		return projectRepository.getCountOfProjects();
	}

}

