package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Services;
import com.example.demo.model.UnitOfMeasure;

public interface UnitOfMeasureServiceInterface {

	UnitOfMeasure findOne(Integer id);

	UnitOfMeasure save(UnitOfMeasure u);
	
	void remove(Integer id);
	
	UnitOfMeasure findByName(String name);
	
	UnitOfMeasure findByShort_name(String sh_name);
	
	List<UnitOfMeasure> findAll();
}
