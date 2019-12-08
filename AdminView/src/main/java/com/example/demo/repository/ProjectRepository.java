package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;
import com.example.demo.mongorepository.ProjectDescStakeRepository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryCustom
{
	public List<Project> findAllByOrderByStartDateAsc();

	
}
