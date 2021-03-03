package com.example.demo.kontroler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EnterpriseDTO;
import com.example.demo.dto.PartnerDTO;
import com.example.demo.model.Enterprise;
import com.example.demo.model.Partner;
import com.example.demo.servis.EnterpriseServiceInterface;
import com.example.demo.servis.PartnerServiceInteface;


@RestController
@RequestMapping(value="salesystem/enterprises")
public class EnterpriseController {
	@Autowired 
	private EnterpriseServiceInterface ent;

	
	@GetMapping
	public ResponseEntity<List<EnterpriseDTO>> getEnterprise() {
		List<Enterprise> enterprises = ent.findAll();
		List<EnterpriseDTO> entDTO = new ArrayList<EnterpriseDTO>();
		for (Enterprise e : enterprises) {
			entDTO.add(new EnterpriseDTO(e));
		}
		return new ResponseEntity<List<EnterpriseDTO>>(entDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{enterprise_id}")
	public ResponseEntity<EnterpriseDTO> getEnterprise(@PathVariable("enterprise_id") Integer enterprise_id){
		Enterprise enterprise = ent.findOne(enterprise_id);
		if(enterprise == null) {
			return new ResponseEntity<EnterpriseDTO>(HttpStatus.NOT_FOUND);
		}
		EnterpriseDTO entDTO = new EnterpriseDTO(enterprise);
		return new ResponseEntity<EnterpriseDTO>(entDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<EnterpriseDTO> saveEnterprise(@RequestBody EnterpriseDTO eDTO){
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterprise_id(eDTO.getEnteprise_id());
		enterprise.setAddress(eDTO.getAddress());
		enterprise.setFax(eDTO.getFax());
		enterprise.setNameEnterprise(eDTO.getNameEnterprise());
		enterprise.setPhone(eDTO.getPhone());
		
		
		ent.save(enterprise);
		return new ResponseEntity<EnterpriseDTO>(eDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{enterprise_id}", consumes="appliction/json")
	public ResponseEntity<EnterpriseDTO> updateEnterprise(@RequestBody EnterpriseDTO eDTO, @PathVariable("enterprise_id") Integer enterprise_id ){
		Enterprise enterprise = ent.findOne(enterprise_id);
		if (enterprise == null) {
			return new ResponseEntity<EnterpriseDTO>(HttpStatus.BAD_REQUEST);
		}
		enterprise.setEnterprise_id(eDTO.getEnteprise_id());
		enterprise.setAddress(eDTO.getAddress());
		enterprise.setFax(eDTO.getFax());
		enterprise.setNameEnterprise(eDTO.getNameEnterprise());
		enterprise.setPhone(eDTO.getPhone());
		ent.save(enterprise);
		EnterpriseDTO entDTO = new EnterpriseDTO(enterprise);
		return new ResponseEntity<EnterpriseDTO>(entDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{enterprise_id}")
	public ResponseEntity<Void> deletePartner(@PathVariable("enterprise_id") Integer enterprise_id){
		Enterprise enterprise = ent.findOne(enterprise_id);
		if (enterprise != null) {
			ent.remove(enterprise_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
