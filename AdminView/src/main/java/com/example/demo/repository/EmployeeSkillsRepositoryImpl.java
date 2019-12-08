package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.entity.EmployeeSkills;

@Repository
@Transactional
public class EmployeeSkillsRepositoryImpl implements EmployeeSkillsRepositoryCustom {

	@Autowired
	public EmployeeSkillsRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeSkills> getEmployeeSkills(Long theId) {
		Query query = entityManager.createQuery("from EmployeeSkills as es join Employee as e on e.employeeId = es.employeeId where e.employeeId=:theId");
		query.setParameter("theId", theId);
		return query.getResultList();
	}

}
