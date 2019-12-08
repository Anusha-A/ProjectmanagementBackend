package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subtask;
import com.example.demo.entity.Task;
import com.example.demo.mysqlrepository.SubtaskRepository;
import com.example.demo.mysqlrepository.TaskRepository;
@Service
public class SubTaskServiceImpl  implements SubTaskService{

	@Autowired
	private SubtaskRepository subTaskRepository;
	
	
	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private NotificationService notificationService;

	
	@Override
	public List<Subtask> findByTaskId(Task task) {		
		return subTaskRepository.getAllSubTasksByTaskId(task);
	}




	@Override
	public Subtask saveSubTask(Subtask subTask) {
		// TODO Auto-generated method stub
		Subtask subtask1 =  subTaskRepository.save(subTask);
		
				
		Long taskId =  subTask.getTaskId().getTaskId();			
		Optional<Task> optionalEntity = taskRepository.findById(taskId);
		Task t = optionalEntity.get();
		t.setSubTaskCount(t.getSubTaskCount() + 1);
		taskRepository.save(t);
		
		
		//Send mail to the employee
		notificationService.SendSubTasknotification(subTask.getEmployeeId());
		
		return subtask1;
	}

}
