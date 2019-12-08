package com.example.demo.mongorepository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProjectDescStake;
@Repository
public interface ProjectDescStakeRepository extends MongoRepository<ProjectDescStake, String> {
	public  List<ProjectDescStake> findByProjectId(Long theId);
}
