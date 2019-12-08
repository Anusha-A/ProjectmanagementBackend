package com.example.demo.mysqlrepository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;

@Repository
@Transactional

public class ProjectMemberRepositoryImpl implements ProjectMemberRepositoryCustom{
	
	
	@PersistenceContext
	EntityManager entityManager;
	

	@Override
	public void saveProjectMember(ProjectMember projectMember) {
		// TODO Auto-generated method stub
		
		//System.out.println(projectMember.getProjectId().getName());
		
		Query query = entityManager.createNativeQuery("\r\n" + 
		 		"insert into project_member( employee_id, project_id ) values(?, ?);")
		 .setParameter(1,projectMember.getEmployeeId().getEmployeeId())
		 .setParameter(2,projectMember.getProjectId().getProjectId());
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectMember> getProjectMemberByProjectId(Project project) {
		// TODO Auto-generated method stub		
		Query query = entityManager.createNativeQuery("select * from project_member pm inner join employee e  where pm.project_id=:projectId "
				+ "and e.employee_id = pm.employee_id\r\n" + 
				"			and \r\n" + 
				"			e.user_type='MEMBER'", ProjectMember.class);
		query.setParameter("projectId", project.getProjectId());		
		return query.getResultList();
	}

	@Override
	public void updateAuthority(List<ProjectMember> projectMembersList) {
		Query query;
		
		for (int i = 0; i < projectMembersList.size(); i++) {
			
			 query = entityManager.createNativeQuery("update project_member set authority = false where employee_id=:e and project_id =:p");
			 query.setParameter("e", projectMembersList.get(i).getEmployeeId().getEmployeeId());
			 query.setParameter("p", projectMembersList.get(i).getProjectId().getProjectId());
			 query.executeUpdate();
			
		}
		
	}

}
