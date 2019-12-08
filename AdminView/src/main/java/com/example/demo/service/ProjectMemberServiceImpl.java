package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ProjectMemberController;
import com.example.demo.entity.ProjectMember;
import com.example.demo.repository.ProjectMemberRepository;

@Service
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
	@Autowired
		private ProjectMemberRepository projectMemberRepository;

	@Override
	public List<ProjectMember> getByEmpId(long theId) {
		// TODO Auto-generated method stub
		return  projectMemberRepository.getByEmpId(theId);
	}

	@Override
	public List<ProjectMember> getAllProjectEmployee(Long theId) {
		// TODO Auto-generated method stub
		return projectMemberRepository.getEmpProject(theId);
	}


	

}
