package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Services;

public interface ServicesServiceInterface {

	Services findOne(Integer services_id);
	
	List<Services> findAll();
	
	Services save(Services services);
	
	void remove(Integer services_id);
	
	Services findByName(String name);
	
	Services findByDescription(String description);
	
}
