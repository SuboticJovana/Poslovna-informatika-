package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Enterprise;
import com.example.demo.model.PDVCategory;

import com.example.demo.model.ServiceGroup;


public interface ServiceGroupRepository  extends JpaRepository<ServiceGroup,Integer> {
	
	ServiceGroup findByName(String name);
	
	ServiceGroup findByPDVCategory(PDVCategory p);

	ServiceGroup findByEnterprise(Enterprise p);
}
