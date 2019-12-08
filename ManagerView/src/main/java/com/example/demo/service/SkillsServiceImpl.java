package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Skills;
import com.example.demo.mysqlrepository.SkillsRepository;


@Service
public class SkillsServiceImpl implements SkillsService {

	
	@Autowired
	private SkillsRepository skillsRepository;
	
	@Override
	public List<Skills> getAllSkills() {
		// TODO Auto-generated method stub
		return skillsRepository.findAll();
	}

}
