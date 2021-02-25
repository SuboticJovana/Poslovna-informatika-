package com.example.demo.kontroler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InvoiceItemDTO;
import com.example.demo.dto.PDVRateDTO;
import com.example.demo.dto.PriceListItemDTO;
import com.example.demo.model.InvoiceItem;
import com.example.demo.model.PDVCategory;
import com.example.demo.model.PDVRate;
import com.example.demo.model.PriceListItem;
import com.example.demo.servis.PDVRateServiceInterface;

@RestController
@RequestMapping(value="sales-system/pdv-rates")
public class PDVRateContoller {
	
	@Autowired
	private PDVRateServiceInterface pdvRateServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<PDVRateDTO>> getRates() {
		List<PDVRate> rates = pdvRateServiceInterface.findAll();
		List<PDVRateDTO> ratesDTO = new ArrayList<PDVRateDTO>();
		for (PDVRate r : rates) {
			ratesDTO.add(new PDVRateDTO(r));
		}
		return new ResponseEntity<List<PDVRateDTO>>(ratesDTO, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{pdv_rate_id}")
	public ResponseEntity<PDVRateDTO> getRate(@PathVariable("pdv_rate_id") Integer pdv_rate_id){
		PDVRate rate = pdvRateServiceInterface.findOne(pdv_rate_id);
		if(rate == null) {
			return new ResponseEntity<PDVRateDTO>(HttpStatus.NOT_FOUND);
		}
		PDVRateDTO rateDTO = new PDVRateDTO(rate);
		return new ResponseEntity<PDVRateDTO>(rateDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<PDVRateDTO> saveRate(@RequestBody PDVRateDTO rDTO){
		PDVRate rate = new PDVRate();
		rate.setPdv_rate_id(rDTO.getPdv_rate_id());
		rate.setPercentage(rDTO.getPercentage());
		rate.setDate(rDTO.getDate());
		pdvRateServiceInterface.save(rate);
		return new ResponseEntity<PDVRateDTO>(rDTO, HttpStatus.CREATED);
	}

	@PutMapping(value="/{drv_rate_id}", consumes="application/json")
	public ResponseEntity<PDVRateDTO> updateRate(@RequestBody PDVRateDTO rDTO, @PathVariable("pdv_rate_id") Integer pdv_rate_id){
		PDVRate rate = pdvRateServiceInterface.findOne(pdv_rate_id);
		if (rate == null) {
			return new ResponseEntity<PDVRateDTO>(HttpStatus.BAD_REQUEST);
		}				
		rate.setPdv_rate_id(rDTO.getPdv_rate_id());
		rate.setPercentage(rDTO.getPercentage());
		rate.setDate(rDTO.getDate());
		pdvRateServiceInterface.save(rate);
		PDVRateDTO rateDTO = new PDVRateDTO(rate);
		return new ResponseEntity<PDVRateDTO>(rateDTO, HttpStatus.OK);	
	}
	
	@DeleteMapping(value="/{pdv_rate_id}")
	public ResponseEntity<Void> deleteRate(@PathVariable("pdv_rate_id") Integer pdv_rate_id){
		PDVRate rate = pdvRateServiceInterface.findOne(pdv_rate_id);
		if (rate != null){
			pdvRateServiceInterface.remove(pdv_rate_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
