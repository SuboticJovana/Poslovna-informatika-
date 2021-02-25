package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Partner;
import com.example.demo.repozitorijum.PartnerRepository;

public class PartnerService implements PartnerServiceInteface{

	@Autowired
	PartnerRepository partnerRepository;

	@Override
	public Partner findOne(Integer partner_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partner save(Partner partner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partner remove(Partner partner_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Partner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
