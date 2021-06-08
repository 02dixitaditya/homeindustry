package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="city", nullable=false)
    private String city;
   
    @Column(name="date", nullable=false)
    private String date;
   
    @Column(name="slot", nullable=false)
    private String slot;
   
    @Column(name="status", nullable=false)
    private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Inspection(int id, String city, String date, String slot, int status) {
		super();
		this.id = id;
		this.city = city;
		this.date = date;
		this.slot = slot;
		this.status = status;
	}

	public Inspection() {
		super();
	}
	   	  
	   
}
