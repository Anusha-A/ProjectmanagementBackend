package com.example.demo.mysqlrepository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;




@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepositoryCustom{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<ProjectMember> completeProject(Project project) {
		// TODO Auto-generated method stub
		
		 Query query = entityManager.createNativeQuery("select * from project_member where "
			 		+ " projectId=:projectId); ", 
			 		Employee.class);
		 query.setParameter("projectId", project.getProjectId());
			 
		 return  query.getResultList();
		/*
		 * for (int i = 0; i < projectMembersList.size(); i++) {
		 * 
		 * ProjectMember projectMember = projectMembersList.get(i);
		 * 
		 * }
		 */
		
	}
	
	
	


	


	
	
	
	

}
