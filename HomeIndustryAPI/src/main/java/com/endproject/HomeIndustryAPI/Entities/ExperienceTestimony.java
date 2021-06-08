package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="experience_testimony")
public class ExperienceTestimony {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;

     @Column(name="user_id", nullable=false)
     private String userId;
     
     @Column(name="name")
     private String name;
     
     @Lob
     private byte[] testimony;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getTestimony() {
		return testimony;
	}

	public void setTestimony(byte[] testimony) {
		this.testimony = testimony;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExperienceTestimony(int id, String userId, String name, byte[] testimony) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.testimony = testimony;
	}

	public ExperienceTestimony() {
		super();
	}
     
     
}
