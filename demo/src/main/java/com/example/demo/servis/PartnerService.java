package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Partner;
import com.example.demo.repozitorijum.PartnerRepository;
@Service
public class PartnerService implements PartnerServiceInteface{

	@Autowired
	PartnerRepository partnerRepository;

	@Override
	public Partner findOne(Integer partner_id) {
		return partnerRepository.getOne(partner_id);
	}

	@Override
	public Partner save(Partner partner) {
		return partnerRepository.save(partner);
	}

	@Override
	public void remove(Integer partner_id) {
		partnerRepository.deleteById(partner_id);
	}

	@Override
	public List<Partner> findAll() {
		return partnerRepository.findAll();
	}


	
	
	
	
}
