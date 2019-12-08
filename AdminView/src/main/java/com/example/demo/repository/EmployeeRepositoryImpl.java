package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;


@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom
 {
	
	@Autowired
	public EmployeeRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmp(String value) {
		
			String val = "ADMIN";
			Query query = entityManager.createQuery("from Employee where userType!=:val and firstName Like :value or lastName Like :value or middleName Like :value or firstName=:vname or lastName=:vname or middleName=:vname");
			
			query.setParameter("val", val);
			query.setParameter("value","%"+value+"%");
			query.setParameter("vname", value);
			return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmp() {
		String val = "ADMIN";
		Query query = entityManager.createQuery("from Employee where userType!=:val");
		
		query.setParameter("val", val);
		
		return query.getResultList();
	}
	
	

}
