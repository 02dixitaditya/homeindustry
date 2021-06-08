package com.endproject.HomeIndustryAPI.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endproject.HomeIndustryAPI.Entities.BookedSlot;

public interface BookedSlotDao extends JpaRepository<BookedSlot,String>{

	List<BookedSlot> findByDate(String date);
}
