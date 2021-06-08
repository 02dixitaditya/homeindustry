package com.endproject.HomeIndustryAPI.Controllers;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.endproject.HomeIndustryAPI.Entities.Applicant;
import com.endproject.HomeIndustryAPI.Services.ApplicantService;
import com.endproject.HomeIndustryAPI.Services.EmailService;
import com.endproject.HomeIndustryAPI.Services.EncryptionService;
import net.bytebuddy.utility.RandomString;


@RestController
@EnableAsync
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicantController {

	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EncryptionService encryptionService;
	
	@PostMapping("/addApplicant")
    public String addApplicant(@RequestBody Applicant applicant) throws Exception {

		String password=applicant.getPassword();
		String encPassword=encryptionService.encrypt(password);
		
		String verificationCode=RandomString.make(64);
		applicant.setVerificationCode(verificationCode);
		applicant.setVerificationStatus(false);
		applicant.setRegistrationStatus(1);
		applicant.setPassword(encPassword);
    	applicantService.addApplicant(applicant);
    	emailService.sendEmail(applicant);
 	    return "Registration Successful! Check your mail for verification link";
    }
	
    @PostMapping("/login")
    public ResponseEntity<Applicant> loginUser(@RequestBody Applicant applicant){
        String userId=applicant.getUserId();
        String password=applicant.getPassword();
        String encPassword=null;
        try {
          encPassword=encryptionService.encrypt(password);}
        catch(Exception e) {	
        }
        Applicant ob=null;
        if(userId != null && password != null){
        	try {
          ob=applicantService.getApplicantById(userId);
        	}catch(Exception e) {
        		return null;
        	}
            if(ob==null) {
            	return null;
            }
            
            else if(ob.getPassword().equals(encPassword)) {
            	return ResponseEntity.ok().body(ob);
            }
        }
           	return null;
    }
    
    @GetMapping("/getApplicant/{user_id}")
    public Applicant getApplicant(@PathVariable String userId) {
    	return this.applicantService.getApplicantById(userId);
    }
    
    @GetMapping(value="/verify/{verificationCode}", produces = MediaType.TEXT_HTML_VALUE)
    public String verifyApplicant(@PathVariable String verificationCode) {
    	Applicant applicant;
    	applicant=this.applicantService.findApplicantByVcode(verificationCode);
    	if(applicant==null) {
    		return 
    		"<html>" + "<header><title>Verification</title></header>" +
            "<body><h1 style=\"color:red;\">" + "Invalid Link" + "</h1></body>" + "</html>";
    	}
    	else if(applicant.getVerificationStatus()) {
    		return 
    		"<html>" + "<header><title>Verification</title></header>" +
            "<body><h1 style=\"color:red;\">" + "Email already verified" + "</h1></body>" + "</html>";
    	}
    	else {
    		this.applicantService.enableVerificationStatus(applicant);
    		return 
    		"<html>" + "<header><title>Verification</title></header>" +
            "<body><h1 style=\"color:green;\">" + "Email Verification Successful" + "</h1><br>"+"<p>"+
    		"<a href=\"http://localhost:4200/login\">"+"Continue registration"+"</a>"+"</body>" + "</html>";
    	}
    }
    
    @PostMapping("/updateRegistrationStatus")
    public String updateStatus(@RequestBody Applicant applicant) throws MessagingException {
		String userId=applicant.getUserId();
		int status=applicant.getRegistrationStatus();
		Applicant ob=null;
    	ob=applicantService.getApplicantById(userId);
    	ob.setRegistrationStatus(status);
    	applicantService.updateApplicant(ob);
 	    return "success";
    }
    

	  
}

