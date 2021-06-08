package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {

	@Id
	@Column(name="user_id",nullable=false)
	private String userId;
	
	@Column(name="license_no",nullable=false)
	private String licenseNo;
	
	@Column(name="registered_name",nullable=false)
	private String registeredName;
	
	@Column(name="ownership_detail",nullable=false)
	private String ownershipDetail;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getRegisteredName() {
		return registeredName;
	}

	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}

	public String getOwnershipDetail() {
		return ownershipDetail;
	}

	public void setOwnershipDetail(String ownershipDetail) {
		this.ownershipDetail = ownershipDetail;
	}

	public Organization(String userId, String licenseNo, String registeredName, String ownershipDetail) {
		super();
		this.userId = userId;
		this.licenseNo = licenseNo;
		this.registeredName = registeredName;
		this.ownershipDetail = ownershipDetail;
	}

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
