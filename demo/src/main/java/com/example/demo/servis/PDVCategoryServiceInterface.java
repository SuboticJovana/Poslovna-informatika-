package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.PDVCategory;


public interface PDVCategoryServiceInterface {

	PDVCategory findOne(Integer id);
	
	PDVCategory save(PDVCategory p);
	
	void remove(Integer p);

	PDVCategory findByName(String name);
	
//	PDVCategory findByServiceGroup(ServiceGroup s);

//	PDVCategory findByPDVRate(PDVRate p);

	List<PDVCategory> findAll();
}
