package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Subtask;

@Repository
public class SubtaskDAOImpl implements SubtaskDAO 
{
	


	private EntityManager entityManager;
	
	
	public SubtaskDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subtask> getAllSubtasks(long projectId,long taskId) 
	{
		Query query = entityManager.createQuery("select e.firstName,e.lastName, sb.dueDate, sb.subTaskTitle,sb.subTaskDescription,sb.startDate,sb.progressPercentage from Subtask sb join Task t on sb.taskId=t.taskId join Project p on p.projectId = t.projectId join Employee e on e.employeeId=sb.employeeId where p.projectId=:projectId and t.taskId=:taskId");
		query.setParameter("projectId", projectId);
		query.setParameter("taskId", taskId);
		return query.getResultList();
	}

}
