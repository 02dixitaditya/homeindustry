package com.endproject.HomeIndustryAPI.Services;

import com.endproject.HomeIndustryAPI.Entities.Applicant;

public interface ApplicantService {

	public Applicant addApplicant(Applicant applicant);
	
	public Applicant updateApplicant(Applicant applicant);
    
	public Applicant getApplicantById(String userId);

	public Applicant findApplicantByVcode(String verificationCode);

	public void enableVerificationStatus(Applicant applicant);


}
