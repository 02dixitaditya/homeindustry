package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookedSlot {

	@Id
	@Column(name="user_id", nullable=false)
	private String userId;
	
	@Column(name="city", nullable=false)
    private String city;
   
    @Column(name="date", nullable=false)
    private String date;
   
    @Column(name="slot", nullable=false)
    private String slot;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public BookedSlot(String userId, String city, String date, String slot) {
		super();
		this.userId = userId;
		this.city = city;
		this.date = date;
		this.slot = slot;
	}

	public BookedSlot() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
