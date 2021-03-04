package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;
@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
	City findByPtt(String ptt);
	
	City findByName(String city_name);
}
