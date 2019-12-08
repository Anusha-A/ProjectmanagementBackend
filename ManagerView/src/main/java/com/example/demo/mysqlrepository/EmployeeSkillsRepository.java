package com.example.demo.mysqlrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.composite.ProjectEmployeeSkillsComposite;
import com.example.demo.entity.EmployeeSkills;


@Repository
public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, ProjectEmployeeSkillsComposite>, EmployeeSkillsRepositoryCustom
{
		

}
