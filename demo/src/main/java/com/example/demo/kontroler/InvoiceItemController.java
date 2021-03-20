package com.example.demo.kontroler;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.servis.EnterpriseServiceInterface;
import com.example.demo.servis.InvoiceItemServiceInterface;
import com.example.demo.servis.InvoiceServiceInterface;
import com.example.demo.servis.PartnerServiceInteface;
import com.example.demo.servis.ServicesServiceInterface;

@RestController
@RequestMapping(value="salesystem/invoiceItems")
public class InvoiceItemController {

	@Autowired
	private InvoiceItemServiceInterface service;
	
	@Autowired
	private ServicesServiceInterface servicesService;
	
	@Autowired
	private InvoiceServiceInterface invoiceService;
	
	@Autowired
	private EnterpriseServiceInterface enterpriseService;
	
	@Autowired
	private PartnerServiceInteface partnerService;
	
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
	
	@Transactional
	@PostMapping(consumes="application/json")
	public ResponseEntity<Boolean> saveItem(@RequestBody List<InvoiceItemDTO> invoiceItems){
		Invoice invoice = new Invoice();
		//check buisness year
		//Računanje iznosa za plaćanje i PDV-a za svaku stavku fakture kao i za fakturu u celini,
		//prilikom unosa stavki fakture (koristiti cenovnik i iznos PDV-a koji je važeći u odnosu na datum fakture)
		InvoiceItemDTO firstItem = invoiceItems.get(0);
		System.out.println("this is first item"+ firstItem.getDiscount());
		invoice.setDate_currency(firstItem.getDate_currency());
		invoice.setDate(firstItem.getDate_invoice());
		invoice.setNumber(500); //?
		invoice.setStatus("reserved"); //status ?
		invoice.setTotal_amount(500.0); //calculate total amount?
		invoice.setTotal_base(500.0);//calculate total base?
		invoice.setTotalPdv(50.0);//calculate total pdv?
		invoice.setEnterprise(enterpriseService.findOne(1)); //after login function add enterprise
		invoice.setPartner(partnerService.findOne(firstItem.getPartner_id()));
		invoiceService.save(invoice);
	//
		for(InvoiceItemDTO uDTO : invoiceItems) {
			InvoiceItem item = new InvoiceItem();
			item.setDiscount(uDTO.getDiscount());
			item.setPDVAmount(uDTO.getPdvAmount());
			item.setPDVBase(uDTO.getPdvBase());
			item.setQuantity(uDTO.getQuantity());
			item.setTotalAmount(uDTO.getTotalAmount());
			item.setUnitPrice(uDTO.getUnitPrice());
			item.setServices(servicesService.findOne(uDTO.getService_id()));
			item.setInvoice(invoice); //set reference to invoice
			InvoiceItem i = service.save(item);
			System.out.println(i.getQuantity());
		}
		//add false if it fails
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<InvoiceItemDTO> updateItem(@RequestBody InvoiceItemDTO uDTO, @PathVariable("id") Integer id){
		InvoiceItem item = service.findOne(id);
		if (item == null) {
			return new ResponseEntity<InvoiceItemDTO>(HttpStatus.BAD_REQUEST);
		}				
		item.setDiscount(uDTO.getDiscount());
		item.setPDVAmount(uDTO.getPdvAmount());
		item.setPDVBase(uDTO.getPdvBase());
		item.setQuantity(uDTO.getQuantity());
		item.setTotalAmount(uDTO.getTotalAmount());
		item.setUnitPrice(uDTO.getUnitPrice());
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