package com.example.demo.mysqlrepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;



@Repository
@Transactional


public class TaskRepositoryImpl  implements TaskRepositoryCustom{
	

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllTasksByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		 Query query = entityManager.createNativeQuery("select * from task where project_id=:projectId",Task.class);
		query.setParameter("projectId", projectId)	;
		return query.getResultList();
	}

	

}
