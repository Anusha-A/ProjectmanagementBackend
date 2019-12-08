package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectMemberRepository;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired	
	private EntityManager entityManager;

	
	
	public ProjectDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getCompletedProjects(long empId) {
		//boolean val = true;
		Long id = 1L;
		//Optional<Employee> emp = projectMemberRepository.findById(id);
		
		Query query = entityManager.createQuery("select projectId from ProjectMember where employeeId=:empId ");
		query.setParameter("empId", id);
		//query.setParameter("val", val);
	
		
		return query.getResultList();
		//return null;
	}

}
