package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface UserDao extends CrudRepository<Employee, Integer>{
     Employee findByUsername(String username);
}