package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Integer> {
	Services findByName(String name);
	Services findByDescription(String description);
	Services findByGoods(Boolean goods);
	

}
