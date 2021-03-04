package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PDVRate;
import com.example.demo.repozitorijum.PDVRateRepository;
@Service
public class PDVRateService implements PDVRateServiceInterface{
	
	@Autowired
	PDVRateRepository pdvRateRepository;

	@Override
	public PDVRate findOne(Integer pdv_rate_id) {
		return pdvRateRepository.getOne(pdv_rate_id);
	}

	@Override
	public PDVRate save(PDVRate pdvRate) {
		return pdvRateRepository.save(pdvRate);
	}

	@Override
	public void remove(Integer pdv_rate_id) {
		pdvRateRepository.deleteById(pdv_rate_id);
	}

	@Override
	public List<PDVRate> findAll() {
		return pdvRateRepository.findAll();
	}
	
	

}
