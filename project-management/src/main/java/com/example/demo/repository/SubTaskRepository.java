package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;


@Repository
public interface SubTaskRepository extends JpaRepository<Subtask, Long>
{
		public List<Subtask> findByEmployeeId(Optional<Employee> emp);
		
		public Subtask findBySubTaskId(Long subtaskid);
		
		public List<Subtask> findByTaskId(Task taskId);

}

