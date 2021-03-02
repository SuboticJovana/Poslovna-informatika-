package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Services;
import com.example.demo.repozitorijum.ServicesRepository;

public class ServicesService implements ServicesServiceInterface {
	
	@Autowired
	ServicesRepository servicesRepository;

	@Override
	public Services findOne(Integer services_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Services> findAll() {
		// TODO Auto-generated method stub
		return servicesRepository.findAll();
	}

	@Override
	public Services save(Services services) {
		// TODO Auto-generated method stub
		return servicesRepository.save(services);
	}

	@Override
	public void remove(Integer services_id) {
		// TODO Auto-generated method stub
	//	return servicesRepository.deleteById(services_id);
		
	}

	@Override
	public Services findByName(String name) {
		// TODO Auto-generated method stub
		return servicesRepository.findByName(name);
	}

	@Override
	public Services findByDescription(String description) {
		// TODO Auto-generated method stub
		return servicesRepository.findByDescription(description);
	}

}
