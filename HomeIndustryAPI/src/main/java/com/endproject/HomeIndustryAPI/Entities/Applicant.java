package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Applicant {

	@Id
	@Column(name = "user_id", nullable = false)
	private String userId;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "salutation", nullable = false)
	private String salutation;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "middle_name", nullable = true)
	private String middleName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "house_no", nullable = false)
	private String houseNo;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "area", nullable = false)
	private String area;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "landmark", nullable = false)
	private String landmark;
	
	@Column(name = "phone_no", nullable = false)
	private String phoneNo;
	
	@Column(name = "alternate_no", nullable = false)
	private String alternateNo;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "alternate_email", nullable = false)
	private String alternateEmail;
	
	@Column(name = "fax" , nullable = true)
	private String fax;
	
	@Column(name = "tax_id", nullable = false)
	private String taxId;
	
	@Column(name = "applicant_type", nullable = false)
	private String applicantType;
	
	@Column(name = "verification_code" , updatable = false)
	private String verificationCode;
	
	@Column(name = "verification_status", nullable=false)
	private Boolean verificationStatus;
	
	@Column(name = "resigtration_status", nullable=false)
	private int registrationStatus;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getApplicantType() {
		return applicantType;
	}
	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}
	public Boolean getVerificationStatus() {
		return verificationStatus;
	}
	public void setVerificationStatus(Boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	public int getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(int registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAlternateNo() {
		return alternateNo;
	}
	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	
	
	
	public Applicant(String userId, String password, String salutation, String firstName, String middleName,
			String lastName, String houseNo, String streetName, String area, String city, String state, String country,
			String landmark, String phoneNo, String alternateNo, String email, String alternateEmail, String fax,
			String taxId, String applicantType, String verificationCode, Boolean verificationStatus,
			int registrationStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.salutation = salutation;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.alternateNo = alternateNo;
		this.email = email;
		this.alternateEmail = alternateEmail;
		this.fax = fax;
		this.taxId = taxId;
		this.applicantType = applicantType;
		this.verificationCode = verificationCode;
		this.verificationStatus = verificationStatus;
		this.registrationStatus = registrationStatus;
	}
	
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
