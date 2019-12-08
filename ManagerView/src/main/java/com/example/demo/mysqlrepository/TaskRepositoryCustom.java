package com.example.demo.mysqlrepository;

import java.util.List;
import com.example.demo.entity.Task;

public interface TaskRepositoryCustom {
	
	List<Task> getAllTasksByProjectId(Long projectId);
	
	

}
