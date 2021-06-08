package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	@Column(name="user_id",nullable=false)
	private String userId;
    
	@Column(name="account_no",nullable=false)
	private String accountNo;
	
	@Column(name="ifsc",nullable=false)
	private String ifsc;
	
	@Column(name="alt_account",nullable=false)
	private String altAccount;
	
	@Column(name="nominee_name",nullable=false)
	private String nomineeName;
	
	@Column(name="nominee_relation",nullable=false)
	private String nomineeRelation;
	
	@Column(name="nominee_contact",nullable=false)
	private String nomineeContact;
	
	@Column(name="nominee_email",nullable = true)
	private String nomineeEmail;
	
	@Column(name="nominee_address",nullable=false)
	private String nomineeAddress;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getAltAccount() {
		return altAccount;
	}

	public void setAltAccount(String altAccount) {
		this.altAccount = altAccount;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeRelation() {
		return nomineeRelation;
	}

	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}

	public String getNomineeContact() {
		return nomineeContact;
	}

	public void setNomineeContact(String nomineeContact) {
		this.nomineeContact = nomineeContact;
	}

	public String getNomineeEmail() {
		return nomineeEmail;
	}

	public void setNomineeEmail(String nomineeEmail) {
		this.nomineeEmail = nomineeEmail;
	}

	public String getNomineeAddress() {
		return nomineeAddress;
	}

	public void setNomineeAddress(String nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}

	public BankAccount(String userId, String accountNo, String ifsc, String altAccount, String nomineeName,
			String nomineeRelation, String nomineeContact, String nomineeEmail, String nomineeAddress) {
		super();
		this.userId = userId;
		this.accountNo = accountNo;
		this.ifsc = ifsc;
		this.altAccount = altAccount;
		this.nomineeName = nomineeName;
		this.nomineeRelation = nomineeRelation;
		this.nomineeContact = nomineeContact;
		this.nomineeEmail = nomineeEmail;
		this.nomineeAddress = nomineeAddress;
	}

	public BankAccount() {
		super();
	}
	
	
}
