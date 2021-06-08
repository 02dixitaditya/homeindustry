package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experience")
public class Experience {

	@Id
	@Column(name="user_id",nullable=false)
	private String userId;
    
	@Column(name="work_experience",nullable=false)
	private String workExperience;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public Experience(String userId, String workExperience) {
		super();
		this.userId = userId;
		this.workExperience = workExperience;
	}

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
