package com.example.demo.mysqlrepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;



@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllManagerByAvailability() {
				
		 Query query = entityManager.createNativeQuery("select * from employee where user_type= \"MANAGER\" and availability = 1;\n", Employee.class);
		 return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllMembersByAvailability() {
				
		 Query query = entityManager.createNativeQuery("select * from employee where user_type= \"MEMBER\" and availability = 1;\n", Employee.class);
		 return query.getResultList();
	}
	
	
	
	

}
