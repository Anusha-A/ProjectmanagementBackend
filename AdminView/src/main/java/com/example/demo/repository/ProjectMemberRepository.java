package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.composite.ProjectMemberComposite;
import com.example.demo.entity.Employee;
import com.example.demo.entity.ProjectMember;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberComposite>,ProjectMemberRepositoryCustom {

	
	

}
