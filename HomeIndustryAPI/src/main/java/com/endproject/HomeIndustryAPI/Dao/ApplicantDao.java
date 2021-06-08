package com.endproject.HomeIndustryAPI.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endproject.HomeIndustryAPI.Entities.Applicant;

public interface ApplicantDao extends JpaRepository<Applicant,String>{

	Applicant findByVerificationCode(String verificationCode);
 
}
