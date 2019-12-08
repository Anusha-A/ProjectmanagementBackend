package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "projectDescStake")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProjectDescStake {
	private ObjectId _id;
	
	public String get_id() {
		return _id.toHexString();
	}

	
	private Long projectId;	
	
	
	private String projectDesc;
	

	private String stakeholders;


	@Override
	public String toString() {
		return "ProjectDescStake [projectId=" + projectId + ", projectDesc=" + projectDesc + ", stakeholders="
				+ stakeholders + "]";
	}
	
	
}
