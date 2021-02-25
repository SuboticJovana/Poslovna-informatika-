package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.PDVCategory;
import com.example.demo.model.Preduzece;
import com.example.demo.model.RobaUsluga;
import com.example.demo.model.ServiceGroup;

public interface ServiceGroupServiceInterface {

	ServiceGroup findOne(Integer id);
	
	ServiceGroup save(ServiceGroup serviceGroup);
	
	void remove(Integer id);
	
	ServiceGroup findByName(String name);
	
	ServiceGroup findByRobaUsluga(RobaUsluga service);

	ServiceGroup findByPDVCategory(PDVCategory p);

	ServiceGroup findByPreduzece(Preduzece p);
	
	List<ServiceGroup> findAll();
}
