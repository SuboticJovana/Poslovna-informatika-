package com.example.demo.servis;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BusinessYear;

public interface BusinessYearServiceInterface {

	BusinessYear findOne(Integer idYear);

	BusinessYear save(BusinessYear businessYear);
	
	void remove(Integer idYear);
	
	List<BusinessYear> findAll();
	
	BusinessYear getCurrentYear(Date currentDate);

}
