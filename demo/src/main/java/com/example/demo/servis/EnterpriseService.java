package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Enterprise;
import com.example.demo.repozitorijum.EnterpriseRepository;

public class EnterpriseService implements EnterpriseServiceInterface {
	@Autowired
	EnterpriseRepository enterpriseRepository;

	@Override
	public Enterprise findOne(Integer enterprise_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enterprise> findAll() {
		// TODO Auto-generated method stub
		return enterpriseRepository.findAll();
	}

	@Override
	public Enterprise save(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return enterpriseRepository.save(enterprise);
	}

	@Override
	public void remove(Integer enterprise_id) {
		enterpriseRepository.deleteById(enterprise_id);
		
	}

	@Override
	public Enterprise findByName(String nameEnterprise) {
		// TODO Auto-generated method stub
		return enterpriseRepository.findByName(nameEnterprise);
	}

}

