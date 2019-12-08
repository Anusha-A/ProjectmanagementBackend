package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Project;
import com.example.demo.mongorepository.ProjectDescStakeRepository;
public interface ProjectRepositoryCustom {
	List<Project> getAllCompletedProjects();
	List<Project> getAllOngingProjects();
	List<Project> getprojectById(Long theId);
	List<Project> findOngoingProjectByYear(Integer theYear);
	List<Project> findCompletedProjectByYear(Integer theYear);
	public List<Project> getLatestProjects();
	public int[] getCountOfProjects();
}
