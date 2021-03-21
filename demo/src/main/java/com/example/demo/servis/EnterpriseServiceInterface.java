package com.example.demo.servis;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Enterprise;

public interface EnterpriseServiceInterface {
	Enterprise findOne(Long enterprise_id);
	List <Enterprise> findAll();
	Enterprise save(Enterprise enterprise);
	void remove(Long enterprise_id);
	Enterprise findByName(String name);
	
	Page<Enterprise> findAll(int pageNo, int pageSize);

}

