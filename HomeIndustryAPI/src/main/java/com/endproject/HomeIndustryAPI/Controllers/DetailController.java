package com.endproject.HomeIndustryAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.endproject.HomeIndustryAPI.Entities.Applicant;
import com.endproject.HomeIndustryAPI.Entities.BankAccount;
import com.endproject.HomeIndustryAPI.Entities.Experience;
import com.endproject.HomeIndustryAPI.Entities.Inspection;
import com.endproject.HomeIndustryAPI.Entities.Organization;
import com.endproject.HomeIndustryAPI.Entities.SlotStatus;
import com.endproject.HomeIndustryAPI.Services.ApplicantService;
import com.endproject.HomeIndustryAPI.Services.DetailService;


@RestController
@EnableAsync
@CrossOrigin(origins = "http://localhost:4200")
public class DetailController {

	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private DetailService detailService;
	

    @PostMapping("/organizationDetail")
    public String addOrganizationDetail(@RequestBody Organization orgDetail) {
    	try {
        detailService.addOrganizationDetail(orgDetail);
    	}catch(Exception e) {
    		return null;
    	}
         return "success";
    }
    
	@PostMapping("/bankAccountDetail")
	public String addAccountDetail(@RequestBody BankAccount accDetail) {
		try {
		detailService.addBankAccountDetail(accDetail);
		}catch(Exception e) {
			return null;
		}
 	    return "success";
	}
	
	  @PostMapping("/uploadIdentity")
	  public String uploadFile(@RequestParam("file1") MultipartFile file1, @RequestParam("user") String user) {
	
	      Applicant ob=new Applicant();
	      ob=applicantService.getApplicantById(user);
	      String applicantType=ob.getApplicantType();
	      String str=null;
	      if(applicantType.equalsIgnoreCase("individual")) {
	    	  str="Aadhar";
	      }
	      if(applicantType.equalsIgnoreCase("organization")) {
	    	  str="RegistrationCertificate";
	      }
		  try {
	          detailService.addDocument(file1,user,str);
	      }catch (Exception e) {
	      return "failed";
	    }
		  return "success";
	  }
	  
	  @PostMapping("/uploadTaxId")
	  public String uploadTaxId(@RequestParam("file2") MultipartFile file2, @RequestParam("user") String user) {

		  String str="TaxId";
		  try {
	      detailService.addDocument(file2,user,str);
	      }catch (Exception e) {
            return "failed";
	    }
		  return "success";
	  }
	  
	  @PostMapping("/uploadExperience")
	  public String uploadFile(@RequestParam("file") MultipartFile[] file, @RequestParam("user") String user,
			  @RequestParam("workExperience") String workExperience) {

		  Experience ob=new Experience();
		  ob.setUserId(user);
		  ob.setWorkExperience(workExperience);
		  try {
	        detailService.addExperienceDetail(ob);
	        for(int i=0;i<file.length;i++) {
            detailService.addTestimony(file[i], user);
	        }
	      }catch (Exception e) {
          return "failed";
	    }
		  return "success";
	  }
	  
	  @GetMapping("/findDate/{city}")
	  public List<SlotStatus> getDate(@PathVariable("city") String city){
		  return detailService.getDate(city);
	  }

	  @GetMapping("/findSlot/{date}/{city}")
	  public List<Inspection> getSlot(@PathVariable("date") String date,@PathVariable("city") String city){
		  return detailService.getSlot(date,city);
	  }

	  @GetMapping("/updateInspection/{date}/{city}/{slot}/{userId}")
	  public void updateInspection(@PathVariable("date") String date,@PathVariable("city") String city,
			  @PathVariable("slot") String slot,@PathVariable("userId") String userId){
		  detailService.updateSlotStatus(date,city,slot);
		  detailService.updateDateStatus(city,date);
		  detailService.addBookedSlot(userId,city,date,slot);
	  }
	  
}

