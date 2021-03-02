package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Pricelist;

public interface PricelistServiceInterface {

	Pricelist findOne(Integer pricelist_id);
	
	List<Pricelist> findAll();
	
	Pricelist save(Pricelist pricelist);
	
	void remove(Integer pricelist_id);
	
	Pricelist findByTotalPrice(Integer total_price);
}
