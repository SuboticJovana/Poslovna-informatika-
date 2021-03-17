package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Enterprise;
import com.example.demo.repozitorijum.EnterpriseRepository;
@Service
public class EnterpriseService implements EnterpriseServiceInterface {
	@Autowired
	EnterpriseRepository enterpriseRepository;

	@Override
	public Enterprise findOne(Integer enterprise_id) {
		return enterpriseRepository.getOne(enterprise_id);
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
		return enterpriseRepository.findByNameEnterprise(nameEnterprise);
	}

	@Override
	public Page<Enterprise> findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return enterpriseRepository.findAll(PageRequest.of(pageNo, pageSize));
	}
	
	

}

