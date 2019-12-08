package com.example.demo.mysqlrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Subtask;


@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Long>, SubTaskRepositoryCustom
{
		

}
