package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProjectMember;
import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;
import com.example.demo.repository.ProjectMemberRepository;
import com.example.demo.repository.TaskRepository;

@Repository
public class SubtaskDAOImpl implements SubtaskDAO {

	private EntityManager entityManager;

	@Autowired
	private ProjectMemberRepository projectMemberRepository;

	@Autowired
	private TaskRepository taskRepository;

	public SubtaskDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public List<ProjectMember> getprojectmember(Long theId) {
		return projectMemberRepository.findByEmployeeId(theId);
	}

	public Optional<Task> getTaskid(Long projectid) {
		return taskRepository.findById(projectid);
	}

	@Override
	public void getAllSubtasks() 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Long empid = 1L;
		//List<ProjectMember> obj = getprojectmember(empid);
		
		//System.out.println(obj.toString()); 
		
		
		/*Query<Subtask> theQuery = currentSession.createQuery
				("from Subtask s where s.taskId = (SELECT taskId from Task where projectId =(SELECT projectId from ProjectMember where employeeId= 1))",
		);*/
		
		Long theid = 1L;
		Query query = currentSession.createQuery("from Subtask");/* where taskId=: id").setParameter("id", theid);*/
		List<Subtask> subtasks = query.getResultList();
		System.out.println(subtasks);
		
		/*List<Subtask> subtasks = theQuery.getResultList();
					
		return subtasks;*/
	}

}
