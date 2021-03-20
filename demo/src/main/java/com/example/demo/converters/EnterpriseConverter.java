package com.example.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EnterpriseDTO;
import com.example.demo.model.Enterprise;

@Component
public class EnterpriseConverter {
	
	@Autowired
	public EnterpriseConverter enterpriseConverter;
	
	public EnterpriseDTO toDTO(Enterprise enterprise) {
		EnterpriseDTO dto = new EnterpriseDTO();
		dto.setEnteprise_id(enterprise.getEnterprise_id());
		dto.setNameEnterprise(enterprise.getNameEnterprise());
		dto.setAddress(enterprise.getAddress());
		dto.setPhone(enterprise.getPhone());
		dto.setFax(enterprise.getFax());
		return dto;
	}	
		public Enterprise toEnterprise(EnterpriseDTO enterpriseDTO) {
			Enterprise e = new Enterprise();
			e.setEnterprise_id(enterpriseDTO.getEnteprise_id());
			e.setNameEnterprise(enterpriseDTO.getNameEnterprise());
			e.setAddress(enterpriseDTO.getNameEnterprise());
			e.setPhone(enterpriseDTO.getPhone());
			e.setFax(enterpriseDTO.getFax());
			return e;	
	}
}
