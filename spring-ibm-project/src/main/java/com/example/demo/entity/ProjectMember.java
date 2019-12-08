package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.composite.ProjectMemberComposite;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "project_member")
@IdClass(ProjectMemberComposite.class)
public class ProjectMember
{
	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
    @JoinColumn(name="team_member_id")
	private Long employeeId;
	
	@Id	
	@ManyToOne(fetch = FetchType.LAZY,optional=true,targetEntity = Project.class)
    @JoinColumn(name="project_id")
	private Long projectId;
}
