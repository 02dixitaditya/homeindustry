package com.endproject.HomeIndustryAPI.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.endproject.HomeIndustryAPI.Entities.BankAccount;
import com.endproject.HomeIndustryAPI.Entities.Experience;
import com.endproject.HomeIndustryAPI.Entities.Inspection;
import com.endproject.HomeIndustryAPI.Entities.Organization;
import com.endproject.HomeIndustryAPI.Entities.SlotStatus;

public interface DetailService {

	public void addDocument(MultipartFile file,String user,String category) throws IOException;	
	
	public void addOrganizationDetail(Organization orgDetail);
	
	public void addBankAccountDetail(BankAccount accDetail);
	
	public void addExperienceDetail(Experience expDetail);
	
	public void addTestimony(MultipartFile file,String user) throws IOException;
	
	public List<SlotStatus> getDate(String city);
	
	public List<Inspection> getSlot(String date,String city);
	
	public Inspection updateSlotStatus(String date,String city,String slot);
	
	public SlotStatus updateDateStatus(String city,String date);
	
	public void addBookedSlot(String userId,String city,String date,String slot);

}
