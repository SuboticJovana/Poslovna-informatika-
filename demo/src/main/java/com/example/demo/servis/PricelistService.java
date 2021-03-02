package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Pricelist;

import com.example.demo.repozitorijum.PricelistRepository;


public class PricelistService implements PricelistServiceInterface {
	
	@Autowired
	PricelistRepository pricelistRepository;
	
	@Override
	public Pricelist findOne(Integer pricelist_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pricelist> findAll() {
		// TODO Auto-generated method stub
		return pricelistRepository.findAll();
	}

	@Override
	public Pricelist save(Pricelist pricelist) {
		return pricelistRepository.save(pricelist);
	}

	@Override
	public void remove(Integer pricelist_id) {
		pricelistRepository.deleteById(pricelist_id);
		
	}

	@Override
	public Pricelist findByTotalPrice(Integer total_price) {
		// TODO Auto-generated method stub
		return pricelistRepository.findByTotalPrice(total_price);
	}


	}

