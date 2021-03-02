package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Enterprise;

public interface EnterpriseServiceInterface {
	Enterprise findOne(Integer enterprise_id);
	List <Enterprise> findAll();
	Enterprise save(Enterprise enterprise);
	void remove(Integer enterprise_id);
	Enterprise findByName(String name);

}

