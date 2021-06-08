package com.endproject.HomeIndustryAPI.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.endproject.HomeIndustryAPI.Entities.Inspection;

public interface InspectionDao extends JpaRepository<Inspection,Integer> {
	
	List<Inspection> findByDateAndCity(String date,String city);
	Inspection findByDateAndCityAndSlot(String date,String city,String slot);

}
