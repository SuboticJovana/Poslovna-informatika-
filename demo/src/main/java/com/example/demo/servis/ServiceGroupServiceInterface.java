package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Enterprise;
import com.example.demo.model.PDVCategory;
import com.example.demo.model.ServiceGroup;

public interface ServiceGroupServiceInterface {

	ServiceGroup findOne(Integer id);
	
	ServiceGroup save(ServiceGroup serviceGroup);
	
	void remove(Integer id);
	
	ServiceGroup findByName(String name);
	
	ServiceGroup findByPDVCategory(PDVCategory p);

	ServiceGroup findByEnterprise(Enterprise p);
	
	List<ServiceGroup> findAll();
}
