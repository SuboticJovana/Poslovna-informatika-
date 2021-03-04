package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Services;
import com.example.demo.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Integer>{

	UnitOfMeasure findByName(String name);
	
	UnitOfMeasure findByShortName(String sh_name);
	

}
