package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Partner;

public interface PartnerServiceInteface {
	
	Partner findOne(Integer partner_id);
	
	Partner save(Partner partner);
	
	void remove(Integer partner_id);
	
	List<Partner> findAll();
	
}
