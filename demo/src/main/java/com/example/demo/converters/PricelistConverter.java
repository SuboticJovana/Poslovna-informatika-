package com.example.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.dto.PricelistDTO;
import com.example.demo.model.Pricelist;
import com.example.demo.servis.EnterpriseServiceInterface;

@Component
public class PricelistConverter {
	
	@Autowired
	public PricelistConverter pricelistConverter;
	
	@Autowired
	EnterpriseConverter enterpriseConverter;
	
	@Autowired
	EnterpriseServiceInterface enterpriseServiceInterface;
	
	public PricelistDTO toDTO(Pricelist pricelist) {
		PricelistDTO dto = new PricelistDTO();
		dto.setPricelist_id(pricelist.getPricelist_id());
		dto.setDate_from(pricelist.getDateFrom());
		dto.setEnterpriseDTO(enterpriseConverter.toDTO(pricelist.getEnterprise()));
		return dto;
	}
	
	public Pricelist toPricelist(PricelistDTO pricelistDTO) {
		Pricelist p = new Pricelist();
		p.setPricelist_id(pricelistDTO.getPricelist_id());
		p.setDateFrom(pricelistDTO.getDate_from());
		p.setEnterprise(enterpriseServiceInterface.findOne(pricelistDTO.getEnterpriseDTO().getEnteprise_id()));
		return p;
	}
}
