package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Project;

public interface ProjectDao {
	public List<Project> getCompletedProjects(long empId);
}
