package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
	Enterprise findByName(String nameEnterprise);
	Enterprise findByAddress(String address);
	Enterprise findByPhone(String phone);
	Enterprise findByFax(String fax);
	

}


