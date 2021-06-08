package com.endproject.HomeIndustryAPI.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.endproject.HomeIndustryAPI.Dao.BookedSlotDao;
import com.endproject.HomeIndustryAPI.Entities.Applicant;
import com.endproject.HomeIndustryAPI.Entities.BookedSlot;

@Service
public class EmailService {

   private JavaMailSender javaMailSender;
	
   @Autowired
   public EmailService(JavaMailSender javaMailSender) {
	  this.javaMailSender = javaMailSender;
   }
   @Autowired
   private BookedSlotDao bookedSlotDao;
   
   public void sendEmail(Applicant applicant) throws MailException, MessagingException{

		MimeMessage mimeMessage = javaMailSender.createMimeMessage(); 
		MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true);
	    String baseURL="http://localhost:9090";
	    String verificationLink=baseURL+"/verify/"+applicant.getVerificationCode();
		String email=applicant.getUserId();
		String subject="Account Verification Required";
		String text="<p>Click the below link to verify your email</p><br>"+verificationLink;
		mail.setTo(email);
		mail.setSubject(subject);
		mail.setText("<html><body>"+text+"</body></html>", true);

		javaMailSender.send(mimeMessage);
	}
   
   
   @Scheduled(fixedRate=1000*60*60*24)
   public void sendReminder() throws InterruptedException, MessagingException{
	   
	   
	   MimeMessage mimeMessage = javaMailSender.createMimeMessage(); 
	   MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true);

	   LocalDateTime today = LocalDateTime.now();  
       LocalDateTime tomorrow = today.plusDays(1);  
       DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
       String tomorrow2 = tomorrow.format(format); 
      
       List<BookedSlot> bookList = bookedSlotDao.findByDate(tomorrow2);
       for (BookedSlot bl : bookList) {
               
    	       String text="<p>An Inspection visit is scheduled tommorow on your selected timing "+bl.getSlot()+".</p><br>Please be available at scheduled time.Thank you!.";
               mail.setTo(bl.getUserId());
               mail.setSubject("Scheduled Inspection Reminder");
               mail.setText("<html><body>"+text+"</body></html>", true);
               javaMailSender.send(mimeMessage);
           
       }



   }
   
}
