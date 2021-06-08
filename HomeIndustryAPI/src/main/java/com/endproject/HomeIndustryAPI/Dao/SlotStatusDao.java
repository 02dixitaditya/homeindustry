package com.endproject.HomeIndustryAPI.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endproject.HomeIndustryAPI.Entities.SlotStatus;

public interface SlotStatusDao extends JpaRepository<SlotStatus,Integer> {

	List<SlotStatus> findByCity(String city);
	SlotStatus findByCityAndDate(String city,String date);
	
}
