package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Enterprise;
import com.example.demo.model.PDVCategory;
import com.example.demo.model.ServiceGroup;
import com.example.demo.model.Services;
import com.example.demo.repozitorijum.ServiceGroupRepository;

@Service
public class ServiceGroupService implements ServiceGroupServiceInterface {

	@Autowired
	private ServiceGroupRepository repository;
	
	@Override
	public ServiceGroup findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public ServiceGroup save(ServiceGroup serviceGroup) {
		return repository.save(serviceGroup);
	}

	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public ServiceGroup findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public ServiceGroup findByRobaUsluga(Services service) {
		return repository.findByRobaUsluga(service);
	}

	@Override
	public ServiceGroup findByPDVCategory(PDVCategory p) {
		return repository.findByPDVCategory(p);
	}

	@Override
	public ServiceGroup findByPreduzece(Enterprise p) {
		return repository.findByPreduzece(p);
	}

	@Override
	public List<ServiceGroup> findAll() {
		return repository.findAll();
	}
	
	


	

	
}
