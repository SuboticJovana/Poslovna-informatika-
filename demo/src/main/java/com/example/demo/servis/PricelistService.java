package com.example.demo.servis;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pricelist;

import com.example.demo.repozitorijum.PricelistRepository;

@Service
public class PricelistService implements PricelistServiceInterface {
	
	@Autowired
	PricelistRepository pricelistRepository;
	
	@Override
	public Pricelist findOne(Integer pricelist_id) {
		return pricelistRepository.getOne(pricelist_id);
	}

	@Override
	public List<Pricelist> findAll() {
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
	public Pricelist findByDateFrom(Date dateFrom) {
		return pricelistRepository.findByDateFrom(dateFrom);
	}

	@Override
	public Page<Pricelist> findAll(int pageNo, int pageSize) {
		return pricelistRepository.findAll(PageRequest.of(pageNo, pageSize));
	}

	@Override
	public Page<Pricelist> findAllByDateFrom(Date dateFrom, int pageNo, int pageSize) {
		return pricelistRepository.findAllByDateFrom(dateFrom, PageRequest.of(pageNo, pageSize));
	}


	}

