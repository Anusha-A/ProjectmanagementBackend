package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Subtask;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
	
	public List<Subtask> findByEmployeeId(Long theId);

}
