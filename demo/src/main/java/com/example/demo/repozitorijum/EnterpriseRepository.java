package com.example.demo.repozitorijum;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
	Enterprise findByNameEnterprise(String nameEnterprise);
	Enterprise findByAddress(String address);
	Enterprise findByPhone(String phone);
	Enterprise findByFax(String fax);
	
	List<Enterprise> findAll();
	
	

}


