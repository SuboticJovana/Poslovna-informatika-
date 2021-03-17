package com.example.demo.kontroler;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.PricelistDTO;
import com.example.demo.model.Enterprise;
import com.example.demo.model.Pricelist;
import com.example.demo.servis.EnterpriseServiceInterface;
import com.example.demo.servis.PriceListItemServiceInterface;
import com.example.demo.servis.PricelistServiceInterface;
import com.sun.el.parser.ParseException;

@RestController
@RequestMapping("salesystem/pricelists")
public class PricelistController {
	
	@Autowired 
	private PricelistServiceInterface pricelistService;
	
	@Autowired
	private EnterpriseServiceInterface enterpriseService;
	
	@Autowired
	private PriceListItemServiceInterface pricelistItemService;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<PricelistDTO>> getPricelist() {
	List<Pricelist> pricelists = pricelistService.findAll();
	List<PricelistDTO> pricelistDTO = new ArrayList<PricelistDTO>();
	for (Pricelist p : pricelists) {
		pricelistDTO.add(new PricelistDTO(p));
	}
	return new ResponseEntity<List<PricelistDTO>>(pricelistDTO, HttpStatus.OK);

	}
	
//	@GetMapping(value="/all")
//	public List<Pricelist> getAll() {
//		return pricelistService.findAll();
//	}
	
//	@GetMapping(value="/p")
//	public ResponseEntity<List<Pricelist>> getAllPricelists(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
//		Page<Pricelist> pricelists = pricelistService.findAll(pageNo, pageSize);
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("total", String.valueOf(pricelists.getTotalPages()));
//		return ResponseEntity.ok().headers(headers).body(pricelists.getContent());
//	}
	
	@GetMapping(value="/{pricelist_id}")
	public ResponseEntity<PricelistDTO> getPricelist(@PathVariable("pricelist_id") Integer pricelist_id){
		Pricelist pricelist = pricelistService.findOne(pricelist_id);
		if(pricelist == null){
			return new ResponseEntity<PricelistDTO>(HttpStatus.NOT_FOUND);
		}
		PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
		return new ResponseEntity<PricelistDTO>(pricelistDTO, HttpStatus.OK);
	}
//	@PostMapping(consumes="application/json")
//	public ResponseEntity<PricelistDTO> savePricelist(@RequestBody PricelistDTO pDTO){
		//ispraviti
//		Pricelist pricelist = new Pricelist();
//		pricelist.setDateFrom(pDTO.getDate_from());
//		pricelist.setDateTo(pDTO.getDate_to());
//		pricelist.setPercentage(pDTO.getPercentage());
//		pricelist.setTotalPrice(pDTO.getTotal_price());

		
//		pricelistService.save(pricelist);
//		PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
//		return new ResponseEntity<PricelistDTO>(pricelistDTO, HttpStatus.CREATED);	
//	}
	
	@PostMapping(value="/addPricelist")
	public ResponseEntity<Void> addPricelist(@Validated @RequestParam("date_from") String dateFrom,
			@RequestParam("enterprise") String nameEnterprise) throws ParseException, java.text.ParseException {
		String datum = dateFrom;
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formater.parse(datum);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Enterprise enterprise = enterpriseService.findByName(nameEnterprise);
		
		if(dateFrom == null || nameEnterprise == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		Pricelist priselist = new Pricelist();
		priselist.setDateFrom(sqlDate);
		priselist.setEnterprise(enterprise);
		pricelistService.save(priselist);
		
		return null;
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<PricelistDTO> updatePricelist(@RequestBody PricelistDTO pDTO, @PathVariable("id") Integer id){
		Pricelist pricelist = pricelistService.findOne(id);
		if (pricelist == null) {
			return new ResponseEntity<PricelistDTO>(HttpStatus.BAD_REQUEST);
		}			
		pricelist.setDateFrom(pDTO.getDate_from());
//		pricelist.setDateTo(pDTO.getDate_to());
//		pricelist.setPercentage(pDTO.getPercentage());
//		pricelist.setTotalPrice(pDTO.getTotal_price());
		
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