package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Project;
import com.example.demo.entity.Task;

@Repository
@Transactional
public class TaskRepositoryImpl implements TaskRepositoryCustom {
	@Autowired
	public TaskRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTaskByProjectId(long projectId) {
		Query query = entityManager.createQuery("from Task as t join Project as p on p.projectId=t.projectId where p.projectId=:projectId");
		query.setParameter("projectId",	Long.valueOf(projectId));
		
		return query.getResultList();
	}
	

}
