package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.SubtaskDAO;
import com.example.demo.entity.Subtask;

@Service
@Transactional
public class SubtaskServiceImpl implements SubtaskService 
{
	private SubtaskDAO subtaskdao;
	
	public SubtaskServiceImpl(SubtaskDAO subtaskdao) {
		super();
		this.subtaskdao = subtaskdao;
	}

	@Override
	public List<Subtask> getAllSubtasks(long projectId,long taskId)
	{
		return subtaskdao.getAllSubtasks(projectId, taskId);
	}

}
