package com.example.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CityDTO;
import com.example.demo.model.City;

@Component
public class CityConverter {
	
	@Autowired
	public CityConverter cityConverter;
	
	public CityDTO toDTO(City city) {
		CityDTO dto = new CityDTO();
		dto.setCity_id(city.getCity_id());
		dto.setPtt(city.getPtt());
		dto.setCity_name(city.getName());
		return dto;
	}
	
	public City toCity(CityDTO cityDTO) {
		City c = new City();
		c.setCity_id(cityDTO.getCity_id());
		c.setPtt(cityDTO.getPtt());
		c.setName(cityDTO.getCity_name());
		return c;
	}

}
