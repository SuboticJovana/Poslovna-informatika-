package com.example.demo.servis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BusinessYear;
import com.example.demo.repozitorijum.BusinessYearRepository;

@Service
public class BusinessYearService implements BusinessYearServiceInterface{
	
	@Autowired
	BusinessYearRepository businessRepository;

	@Override
	public BusinessYear findOne(Integer idYear) {
		return businessRepository.getOne(idYear);
	}

	@Override
	public BusinessYear save(BusinessYear businessYear) {
		return businessRepository.save(businessYear);
	}

	@Override
	public void remove(Integer idYear) {
		 businessRepository.deleteById(idYear);
	}

	@Override
	public List<BusinessYear> findAll() {
		return businessRepository.findAll();
	}

	@Override
	public BusinessYear getCurrentYear(Date currentDate) {
		return businessRepository.getYear(currentDate);
	}
}
