package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {

	Partner findByName(String partner_name);
	
	Partner findByAddress(String address);
	
	Partner findByPhoneNumber(String phone_number);
	
	Partner findByFax(String fax);
	
	Partner findByEmail(String email);
	
}
