package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.BusinessYear;

public interface BusinessYearServiceInterface {

	BusinessYear findOne(Integer idYear);

	BusinessYear save(BusinessYear businessYear);
	
	void remove(Integer idYear);
	
	List<BusinessYear> findAll();
}
