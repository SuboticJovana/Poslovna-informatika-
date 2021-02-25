package com.example.demo.repozitorijum;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PDVRate;
import com.example.demo.model.PriceListItem;


public interface PDVRateRepository extends JpaRepository<PDVRate, Integer>{
	
	PriceListItem findByPercentage(Integer percentage);
	
	PriceListItem findByDate(Date date);
}
