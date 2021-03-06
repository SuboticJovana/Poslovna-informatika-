package com.example.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ServicesDTO;
import com.example.demo.model.Services;
import com.example.demo.servis.ServiceGroupServiceInterface;
import com.example.demo.servis.UnitOfMeasureServiceInterface;

@Component
public class ServicesConverter {

	@Autowired
	public ServicesConverter servicesConverter;
	
	@Autowired
	UnitOfMeasureConverter unitOfMeasureConverter;
	
	@Autowired
	UnitOfMeasureServiceInterface unitOfMeasureServiceInterface;
	
	@Autowired
	ServiceGroupConverter serviceGroupConverter;
	
	@Autowired
	ServiceGroupServiceInterface serviceGroupServiceInterface;
	
	public ServicesDTO toDTO(Services services) {
		ServicesDTO dto = new ServicesDTO();
		dto.setServices_id(services.getService_id());
		dto.setName(services.getName());
		dto.setDescription(services.getDescription());
		dto.setGoods(services.getGoods());
		dto.setServiceGroup(serviceGroupConverter.toDTO(services.getServiceGroup()));
		dto.setUnitOfMeasure(unitOfMeasureConverter.toDTO(services.getUnitOfMeasure()));
		return dto;
	}
	
	public Services toServices(ServicesDTO servicesDTO) {
		Services s = new Services();
		s.setService_id(servicesDTO.getServices_id());
		s.setName(servicesDTO.getName());
		s.setDescription(servicesDTO.getDescription());
		s.setGoods(servicesDTO.getGoods());
		s.setServiceGroup(serviceGroupServiceInterface.findOne(servicesDTO.getServiceGroup().getId()));
		s.setUnit(unitOfMeasureServiceInterface.findOne(servicesDTO.getUnitOfMeasure().getId()));
		return s;
	}

}
