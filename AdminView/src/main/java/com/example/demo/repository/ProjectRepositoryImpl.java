
package com.example.demo.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Project;
@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {
	@Autowired
	public ProjectRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@PersistenceContext
	private EntityManager entityManager;
	
	
	//get all completed projects
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllCompletedProjects() {
		boolean val=true;
		
		Query query = entityManager.createQuery("from Project as p where p.isCompleted=:val");
		query.setParameter("val", val);
	
		return query.getResultList();
	}

		//get all ongoing projects
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllOngingProjects() {
		boolean val=false;
		Query query = entityManager.createQuery("from Project as p where p.isCompleted=:val");
		query.setParameter("val", val);
	
		return query.getResultList();
	}

	
	//find project by id
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getprojectById(Long theId) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Project as p where p.projectId=:theId");
		query.setParameter("theId", theId);
	
		return  query.getResultList();
	}
	
	
	//find project by year for ongoing projects
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Project> findOngoingProjectByYear(Integer theYear) {
		boolean val=false;
		Query query = entityManager.createQuery("from Project as p where YEAR(p.startDate)=:theYear and p.isCompleted=:val");
		query.setParameter("theYear", theYear);
		query.setParameter("val", val);
		return  query.getResultList();
	}

	
	//get project detail from mongo
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Project> findCompletedProjectByYear(Integer theYear) {
		
		boolean val=true;
		Query query = entityManager.createQuery("from Project as p where YEAR(p.startDate)=:theYear and p.isCompleted=:val");
		query.setParameter("theYear", theYear);
		query.setParameter("val", val);
		return  query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getLatestProjects(){
		Calendar d = Calendar.getInstance();
		d.add(Calendar.YEAR, -5);
		Integer t = d.get(Calendar.YEAR);
		Query query = entityManager.createQuery("from Project as p where YEAR(p.startDate)>=:t");
		query.setParameter("t", t);
		return  query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int[] getCountOfProjects()
	{
		int[] a = new int[5];
		for(int i=4;i>=0;i--)
		{
			Calendar d = Calendar.getInstance();
			d.add(Calendar.YEAR, -(4-i));
			Integer t = d.get(Calendar.YEAR);
			Query query = entityManager.createQuery("select count(*) from Project as p where YEAR(p.startDate)=:t");
			query.setParameter("t",  t);
			
			int count = ((Number) query.getSingleResult()).intValue();
			a[i]=count;
			
		}
		return a;
	}

}
