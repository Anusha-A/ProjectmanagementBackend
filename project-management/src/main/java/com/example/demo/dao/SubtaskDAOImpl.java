package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;
import com.example.demo.repository.SubTaskRepository;
import com.example.demo.repository.TaskRepository;



@Repository
public class SubtaskDAOImpl implements SubtaskDAO {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private SubTaskRepository subtaskRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	public SubtaskDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	
	public void updateProgress(Long subtaskId, Long progressPercentage, String comment) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Subtask> theQuery = currentSession.createQuery("update Subtask set progressPercentage=:updated, comment=:newComment where subTaskId=:Id").
				setParameter("updated", progressPercentage).setParameter("Id", subtaskId).setParameter("newComment", comment);
				
		theQuery.executeUpdate();
		
		updateTaskProgress(subtaskId, progressPercentage);
		
		
	}
	
	public void updateTaskProgress(Long subtaskId, Long progressPercentage)
	{
		Long totalProgress = 0L;
		
		Subtask subtask = subtaskRepository.findBySubTaskId(subtaskId);
		//System.out.println(subtask);
		Task taskobj= subtask.getTaskId();
		//System.out.println(taskobj);
		Long taskId = taskobj.getTaskId();
		//System.out.println(taskId);
		List<Subtask> subtasks = subtaskRepository.findByTaskId(taskobj);
		//System.out.println(subtasks);
		for(Subtask eachtask : subtasks)
		{
			//System.out.println(eachtask.getProgressPercentage());
			totalProgress = totalProgress + eachtask.getProgressPercentage();
		}
		System.out.println(totalProgress);
		
		Task tasks = entityManager.find(Task.class, taskId);
		Long subtaskcount =  tasks.getSubTaskCount();
		System.out.println(subtaskcount);
		
		Long updatedval = totalProgress/subtaskcount;
		System.out.println(updatedval);
		tasks.setProgress(updatedval);
		
		//Optional <Task> tasks = taskRepository.findById(taskId);
		//System.out.println(tasks);
		//tasks.g
		//for(Task task: tasks)
		
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Subtask> getAllSubtasks(Long empId) {
		Long val = 100L;
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Subtask> query = currentSession.createQuery("from Subtask as s join Employee as e on e.employeeId = s.employeeId where e.employeeId=:empId and s.progressPercentage !=:val");
		
		query.setParameter("empId", empId);
	
		query.setParameter("val", val);
		return query.getResultList();
		
	}*/

}
