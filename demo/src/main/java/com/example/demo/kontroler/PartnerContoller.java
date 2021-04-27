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

import com.example.demo.converters.PartnerConverter;
import com.example.demo.dto.PartnerDTO;
import com.example.demo.model.Partner;
import com.example.demo.servis.PartnerServiceInteface;

@RestController
@RequestMapping(value="salesystem/partners")
public class PartnerContoller {
	
	@Autowired
	private PartnerServiceInteface partnerServiceInteface;
	
	@Autowired
	PartnerConverter partnerConverter;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<PartnerDTO>> getPartners() {
		List<Partner> partners = partnerServiceInteface.findAll();
		List<PartnerDTO> partnersDTO = new ArrayList<PartnerDTO>();
		for (Partner p : partners) {
			partnersDTO.add(partnerConverter.toDTO(p));
		}
		return new ResponseEntity<List<PartnerDTO>>(partnersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{partner_id}")
	public ResponseEntity<PartnerDTO> getPartner(@PathVariable("partner_id") Integer partner_id){
		Partner partner = partnerServiceInteface.findOne(partner_id);
		if(partner == null) {
			return new ResponseEntity<PartnerDTO>(HttpStatus.NOT_FOUND);
		}
		PartnerDTO partnerDTO = partnerConverter.toDTO(partner);
		return new ResponseEntity<PartnerDTO>(partnerDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value="/add")
	public ResponseEntity<PartnerDTO> savePartner(@RequestBody PartnerDTO pDTO){
		Partner p = partnerConverter.toPartner(pDTO);
		PartnerDTO partnerDTO = partnerConverter.toDTO(p);
		return new ResponseEntity<PartnerDTO>(partnerDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{partner_id}", consumes="appliction/json")
	public ResponseEntity<PartnerDTO> updatePartner(@RequestBody PartnerDTO pDTO, @PathVariable("partner_id") Integer partner_id ){
		Partner partner = partnerServiceInteface.findOne(partner_id);
		if (partner == null) {
			return new ResponseEntity<PartnerDTO>(HttpStatus.BAD_REQUEST);
		}
		Partner p = partnerServiceInteface.save(partnerConverter.toPartner(pDTO));
		PartnerDTO partnerDTO = partnerConverter.toDTO(p);
		return new ResponseEntity<PartnerDTO>(partnerDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/{partner_id}")
	public ResponseEntity<Void> deletePartner(@PathVariable("partner_id") Integer partner_id){
		Partner partner = partnerServiceInteface.findOne(partner_id);
		if (partner != null) {
			partnerServiceInteface.remove(partner_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
