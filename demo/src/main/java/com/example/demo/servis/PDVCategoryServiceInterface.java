package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.PDVCategory;
import com.example.demo.model.PDVRate;
import com.example.demo.model.Partner;
import com.example.demo.model.ServiceGroup;
import com.example.demo.model.UnitOfMeasure;

public interface PDVCategoryServiceInterface {

	PDVCategory findOne(Integer id);
	
	PDVCategory save(PDVCategory p);
	
	void remove(Integer p);

	PDVCategory findByName(String name);
	
	PDVCategory findByServiceGroup(ServiceGroup s);

	PDVCategory findByPDVRate(PDVRate p);

	List<PDVCategory> findAll();
}
