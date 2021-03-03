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

import com.example.demo.dto.InvoiceItemDTO;
import com.example.demo.model.InvoiceItem;
import com.example.demo.servis.InvoiceItemServiceInterface;

@RestController
@RequestMapping(value="salesystem/invoice-items")
public class InvoiceItemController {

	@Autowired
	private InvoiceItemServiceInterface service;
	
	@GetMapping
	public ResponseEntity<List<InvoiceItemDTO>> getInvoiceItems() {
	List<InvoiceItem> items = service.findAll();
	List<InvoiceItemDTO> itemsDTO = new ArrayList<InvoiceItemDTO>();
	for (InvoiceItem u : items) {
		itemsDTO.add(new InvoiceItemDTO(u));
	}
	return new ResponseEntity<List<InvoiceItemDTO>>(itemsDTO, HttpStatus.OK);

	}
	@GetMapping(value="/{id}")
	public ResponseEntity<InvoiceItemDTO> getInvoiceItem(@PathVariable("id") Integer id){
		InvoiceItem item = service.findOne(id);
		if(item == null){
			return new ResponseEntity<InvoiceItemDTO>(HttpStatus.NOT_FOUND);
		}
		InvoiceItemDTO itemDTO = new InvoiceItemDTO(item);
		return new ResponseEntity<InvoiceItemDTO>(itemDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<InvoiceItemDTO> saveItem(@RequestBody InvoiceItemDTO uDTO){
		InvoiceItem item = new InvoiceItem();
		item.setDiscount(uDTO.getDiscount());
		item.setPDV_amount(uDTO.getPDV_amount());
		item.setPDV_base(uDTO.getPDV_base());
		item.setQuantity(uDTO.getQuantity());
		item.setTotal_amount(uDTO.getTotal_amount());
		item.setUnit_price(uDTO.getUnit_price());
		//item.setUsluga(uDTO.getUsluga());
		service.save(item);
		return new ResponseEntity<InvoiceItemDTO>(uDTO, HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<InvoiceItemDTO> updateItem(@RequestBody InvoiceItemDTO uDTO, @PathVariable("id") Integer id){
		InvoiceItem item = service.findOne(id);
		if (item == null) {
			return new ResponseEntity<InvoiceItemDTO>(HttpStatus.BAD_REQUEST);
		}				
		item.setDiscount(uDTO.getDiscount());
		item.setPDV_amount(uDTO.getPDV_amount());
		item.setPDV_base(uDTO.getPDV_base());
		item.setQuantity(uDTO.getQuantity());
		item.setTotal_amount(uDTO.getTotal_amount());
		item.setUnit_price(uDTO.getUnit_price());
		//item.setUsluga(uDTO.getUsluga());
		service.save(item);
		InvoiceItemDTO itemDTO = new InvoiceItemDTO(item);
		return new ResponseEntity<InvoiceItemDTO>(itemDTO, HttpStatus.OK);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id){
		InvoiceItem item = service.findOne(id);
		if (item != null){
			service.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}