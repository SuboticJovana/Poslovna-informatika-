package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.City;
import com.example.demo.repozitorijum.CityRepository;

public class CityService implements CityServiceInteface{

	@Autowired
	CityRepository cityRepository;

	@Override
	public City findOne(Integer city_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City save(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City remove(City city_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
