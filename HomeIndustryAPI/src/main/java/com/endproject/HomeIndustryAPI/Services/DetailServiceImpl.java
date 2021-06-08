package com.endproject.HomeIndustryAPI.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.endproject.HomeIndustryAPI.Dao.BankAccountDao;
import com.endproject.HomeIndustryAPI.Dao.BookedSlotDao;
import com.endproject.HomeIndustryAPI.Dao.DocumentDao;
import com.endproject.HomeIndustryAPI.Dao.ExperienceDao;
import com.endproject.HomeIndustryAPI.Dao.ExperienceTestimonyDao;
import com.endproject.HomeIndustryAPI.Dao.InspectionDao;
import com.endproject.HomeIndustryAPI.Dao.OrganizationDao;
import com.endproject.HomeIndustryAPI.Dao.SlotStatusDao;
import com.endproject.HomeIndustryAPI.Entities.BankAccount;
import com.endproject.HomeIndustryAPI.Entities.BookedSlot;
import com.endproject.HomeIndustryAPI.Entities.Document;
import com.endproject.HomeIndustryAPI.Entities.Experience;
import com.endproject.HomeIndustryAPI.Entities.ExperienceTestimony;
import com.endproject.HomeIndustryAPI.Entities.Inspection;
import com.endproject.HomeIndustryAPI.Entities.Organization;
import com.endproject.HomeIndustryAPI.Entities.SlotStatus;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private OrganizationDao orgDetailDao;
	
	@Autowired
	private BankAccountDao accDetailDao;
	
	@Autowired
	private ExperienceDao expDetailDao;
	
	@Autowired
	private ExperienceTestimonyDao experienceTestimonyDao;
	
	@Autowired
	private SlotStatusDao slotStatusDao;
	
	@Autowired
	private InspectionDao inspectionDao;
	
	@Autowired
	private BookedSlotDao bookedSlotDao;

	@Override
	public void addDocument(MultipartFile file,String user,String category) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    Document ob = new Document();
	    ob.setUserId(user);
	    ob.setDocumentName(fileName);
	    ob.setDocumentCategory(category);
	    ob.setImage(file.getBytes());
	    documentDao.save(ob);
	}

	@Override
	public void addOrganizationDetail(Organization orgDetail) {
		orgDetailDao.save(orgDetail);		
	}

	@Override
	public void addBankAccountDetail(BankAccount accDetail) {
		accDetailDao.save(accDetail);
	}

	@Override
	public void addExperienceDetail(Experience expDetail) {
		expDetailDao.save(expDetail);
	}

	@Override
	public void addTestimony(MultipartFile file, String user) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    ExperienceTestimony ob = new ExperienceTestimony();
	    ob.setUserId(user);
	    ob.setName(fileName);
	    ob.setTestimony(file.getBytes());
	    experienceTestimonyDao.save(ob);
		
	}

	@Override
	public List<SlotStatus> getDate(String city) {
		return slotStatusDao.findByCity(city);
	}

	@Override
	public List<Inspection> getSlot(String date,String city) {
		return inspectionDao.findByDateAndCity(date,city);
	}
	
	@Override
	public Inspection updateSlotStatus(String date,String city,String slot) {
		Inspection ob=inspectionDao.findByDateAndCityAndSlot(date,city,slot);
		ob.setStatus(1);
		inspectionDao.save(ob);
		return ob;
	}

	@Override
	public SlotStatus updateDateStatus(String city, String date) {
		SlotStatus ob=slotStatusDao.findByCityAndDate(city, date);
		int i=ob.getStatus();
		i++;
		ob.setStatus(i);
		slotStatusDao.save(ob);
		return ob;
	}

	@Override
	public void addBookedSlot(String userId, String city, String date, String slot) {
		BookedSlot ob=new BookedSlot();
		ob.setUserId(userId);
		ob.setCity(city);
		ob.setDate(date);
		ob.setSlot(slot);
		bookedSlotDao.save(ob);
		
	}

}
