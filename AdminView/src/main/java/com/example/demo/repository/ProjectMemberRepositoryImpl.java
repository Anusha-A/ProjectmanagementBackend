package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ProjectMember;
@Repository
@Transactional
public class ProjectMemberRepositoryImpl implements ProjectMemberRepositoryCustom {
	@Autowired
	public ProjectMemberRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectMember> getByEmpId(long theId) {
		boolean auth= true;
		Query query = entityManager.createQuery("from ProjectMember as pm join Employee as e on e.employeeId=pm.employeeId where e.employeeId=:theId and pm.authority=:auth");
		query.setParameter("theId",	Long.valueOf(theId));
		query.setParameter("auth", auth);
		
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectMember> getEmpProject(Long theId)
	{
		Query query = entityManager.createQuery("from ProjectMember as pm join Project as p on p.projectId=pm.projectId where p.projectId=:theId");
		
		query.setParameter("theId", Long.valueOf(theId));
		return query.getResultList();
	}


}
