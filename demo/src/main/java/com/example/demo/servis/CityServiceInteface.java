package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.City;

public interface CityServiceInteface {
	
	City findOne(Integer city_id);

	City save(City city);
	
	City remove(City city_id);
	
	List<City> findAll();
}
