package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Enterprise;
import com.example.demo.model.PDVCategory;

import com.example.demo.model.ServiceGroup;
import com.example.demo.model.Services;

public interface ServiceGroupRepository  extends JpaRepository<ServiceGroup,Integer> {
	
	ServiceGroup findByName(String name);
	
	ServiceGroup findByRobaUsluga(Services service);

	ServiceGroup findByPDVCategory(PDVCategory p);

	ServiceGroup findByPreduzece(Enterprise p);
}
