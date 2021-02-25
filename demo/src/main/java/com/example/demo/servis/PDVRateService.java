package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.PDVRate;
import com.example.demo.repozitorijum.PDVRateRepository;

public class PDVRateService implements PDVRateServiceInterface{
	
	@Autowired
	PDVRateRepository pdvRateRepository;

	@Override
	public PDVRate findOne(Integer pdv_rate_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PDVRate save(PDVRate pdvRate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PDVRate remove(Integer pdv_rate_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PDVRate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
