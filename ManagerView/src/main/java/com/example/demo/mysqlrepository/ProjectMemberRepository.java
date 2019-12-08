package com.example.demo.mysqlrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.composite.ProjectMemberComposite;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;


@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberComposite>, ProjectMemberRepositoryCustom
{
	List<ProjectMember> findAllByProjectId(Project project); 
}
