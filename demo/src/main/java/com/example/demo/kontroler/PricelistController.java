package com.example.demo.kontroler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.PricelistDTO;
import com.example.demo.model.Pricelist;
import com.example.demo.servis.PricelistServiceInterface;

@RestController
@RequestMapping("sales-system/pricelists")
public class PricelistController {
	
	@Autowired 
	private PricelistServiceInterface pricelistService;
	
	@GetMapping
	public ResponseEntity<List<PricelistDTO>> getPricelist() {
	List<Pricelist> pricelists = pricelistService.findAll();
	List<PricelistDTO> pricelistDTO = new ArrayList<PricelistDTO>();
	for (Pricelist p : pricelists) {
		pricelistDTO.add(new PricelistDTO(p));
	}
	return new ResponseEntity<List<PricelistDTO>>(pricelistDTO, HttpStatus.OK);

	}
	@GetMapping(value="/{pricelist_id}")
	public ResponseEntity<PricelistDTO> getPricelist(@PathVariable("pricelist_id") Integer pricelist_id){
		Pricelist pricelist = pricelistService.findOne(pricelist_id);
		if(pricelist == null){
			return new ResponseEntity<PricelistDTO>(HttpStatus.NOT_FOUND);
		}
		PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
		return new ResponseEntity<PricelistDTO>(pricelistDTO, HttpStatus.OK);
	}
	@PostMapping(consumes="application/json")
	public ResponseEntity<PricelistDTO> savePricelist(@RequestBody PricelistDTO pDTO){
		//ispraviti
		Pricelist pricelist = new Pricelist();
		pricelist.setDate_from(pDTO.getDate_from());
		pricelist.setDate_to(pDTO.getDate_to());
		pricelist.setPercentage(pDTO.getPercentage());
		pricelist.setTotal_price(pDTO.getTotal_price());
		
		pricelistService.save(pricelist);
		PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
		return new ResponseEntity<PricelistDTO>(pricelistDTO, HttpStatus.CREATED);	
	}
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<PricelistDTO> updatePricelist(@RequestBody PricelistDTO pDTO, @PathVariable("id") Integer id){
		Pricelist pricelist = pricelistService.findOne(id);
		if (pricelist == null) {
			return new ResponseEntity<PricelistDTO>(HttpStatus.BAD_REQUEST);
		}			
		pricelist.setDate_from(pDTO.getDate_from());
		pricelist.setDate_to(pDTO.getDate_to());
		pricelist.setPercentage(pDTO.getPercentage());
		pricelist.setTotal_price(pDTO.getTotal_price());
		
		 pricelistService.save(pricelist);
		PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
		return new ResponseEntity<PricelistDTO>(pricelistDTO, HttpStatus.OK);	
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletePricelist(@PathVariable("id") Integer id){
		Pricelist pricelist = pricelistService.findOne(id);
		if (pricelist != null){
			pricelistService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}