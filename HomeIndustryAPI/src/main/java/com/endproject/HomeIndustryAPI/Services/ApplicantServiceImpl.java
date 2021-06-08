package com.endproject.HomeIndustryAPI.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endproject.HomeIndustryAPI.Dao.ApplicantDao;
import com.endproject.HomeIndustryAPI.Entities.Applicant;

@Service
public class ApplicantServiceImpl implements ApplicantService{

	@Autowired
	private ApplicantDao applicantDao;
	
	@Override
	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		applicantDao.save(applicant);
		return applicant;
	}
	
	@Override
	public Applicant updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		applicantDao.save(applicant);
		return applicant;
	}
	
	@Override
	public Applicant getApplicantById(String userId) {
		// TODO Auto-generated method stub
		return applicantDao.findById(userId).get();
	}

	@Override
	public Applicant findApplicantByVcode(String verificationCode) {
		// TODO Auto-generated method stub
		return applicantDao.findByVerificationCode(verificationCode);
	}

	@Override
	public void enableVerificationStatus(Applicant applicant) {
		// TODO Auto-generated method stub
		applicant.setVerificationStatus(true);
		applicantDao.save(applicant);
	}


}
