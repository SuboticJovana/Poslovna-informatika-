package com.example.demo.repozitorijum;

import java.util.Date;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pricelist;

public interface PricelistRepository extends JpaRepository<Pricelist, Integer> {

	Pricelist findByDateFrom(Date date_from);
	
//	Pricelist findByDateTo(Date date_to);
	
//	Pricelist findByPercentage(int percentage);
	
//	Pricelist findByTotalPrice(int total_price);
	
//	List<Pricelist> findAll();
	
	Page<Pricelist> findAllByDateFrom (Date dateFrom, Pageable pegeadble);
}


	