package com.example.demo.mysqlrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Skills;


@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long>
{
		

}
