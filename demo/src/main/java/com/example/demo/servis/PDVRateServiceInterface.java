package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.PDVRate;

public interface PDVRateServiceInterface {

	PDVRate findOne(Integer pdv_rate_id);
	
	PDVRate save(PDVRate pdvRate);
	
	PDVRate remove(Integer prv_rate_id);
	
	List<PDVRate> findAll();
}
