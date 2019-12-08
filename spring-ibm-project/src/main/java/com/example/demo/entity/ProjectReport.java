package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "project_report")
public class ProjectReport 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private Long reportId;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Project.class)
    @JoinColumn(name="project_id")
	private Long projectId;

	@NotNull
	@Column(name = "file_url")
	private String fileURL;
	
	
}
