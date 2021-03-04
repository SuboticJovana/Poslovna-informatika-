package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PDVCategory;
import com.example.demo.model.PDVRate;
import com.example.demo.model.ServiceGroup;

public interface PDVCategoryRepository extends JpaRepository<PDVCategory, Integer> {

	PDVCategory findByName(String name);
	
//	PDVCategory findByServiceGroup(ServiceGroup s);

//	PDVCategory findByPDVRates(PDVRate p);

}
