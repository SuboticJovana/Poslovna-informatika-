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

import com.example.demo.dto.InvoiceDTO;
import com.example.demo.model.Invoice;
import com.example.demo.servis.InvoiceServiceInterface;

@RestController
@RequestMapping(value="salesystem/invoice")
public class InvoiceController {



	@Autowired
	private InvoiceServiceInterface service;
	
	@GetMapping
	public ResponseEntity<List<InvoiceDTO>> getInvoice() {
	List<Invoice> items = service.findAll();
	List<InvoiceDTO> itemsDTO = new ArrayList<InvoiceDTO>();
	for (Invoice u : items) {
		itemsDTO.add(new InvoiceDTO(u));
	}
	return new ResponseEntity<List<InvoiceDTO>>(itemsDTO, HttpStatus.OK);

	}
	@GetMapping(value="/{id}")
	public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable("id") Integer id){
		Invoice item = service.findOne(id);
		if(item == null){
			return new ResponseEntity<InvoiceDTO>(HttpStatus.NOT_FOUND);
		}
		InvoiceDTO itemDTO = new InvoiceDTO(item);
		return new ResponseEntity<InvoiceDTO>(itemDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<InvoiceDTO> saveItem(@RequestBody InvoiceDTO uDTO){
		Invoice item = new Invoice();
		item.setId(uDTO.getId());
		item.setDate_currency(uDTO.getDate_currency());
		item.setDate_invoice(uDTO.getDate_invoice());
		item.setInvoice_number(uDTO.getInvoice_number());
		item.setStatus(uDTO.getStatus());
		item.setTotal_amount(uDTO.getTotal_amount());
		item.setTotal_base(uDTO.getTotal_base());
		item.setTotal_pdv(uDTO.getTotal_pdv());
		
		//item.setUsluga(uDTO.getUsluga());
		service.save(item);
		return new ResponseEntity<InvoiceDTO>(uDTO, HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<InvoiceDTO> updateI(@RequestBody InvoiceDTO uDTO, @PathVariable("id") Integer id){
		Invoice item = service.findOne(id);
		if (item == null) {
			return new ResponseEntity<InvoiceDTO>(HttpStatus.BAD_REQUEST);
		}				
		item.setId(uDTO.getId());
		item.setDate_currency(uDTO.getDate_currency());
		item.setDate_invoice(uDTO.getDate_invoice());
		item.setInvoice_number(uDTO.getInvoice_number());
		item.setStatus(uDTO.getStatus());
		item.setTotal_amount(uDTO.getTotal_amount());
		item.setTotal_base(uDTO.getTotal_base());
		item.setTotal_pdv(uDTO.getTotal_pdv());
		service.save(item);
		InvoiceDTO itemDTO = new InvoiceDTO(item);
		return new ResponseEntity<InvoiceDTO>(itemDTO, HttpStatus.OK);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id){
		Invoice item = service.findOne(id);
		if (item != null){
			service.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}