package com.example.demo.servis;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.InvoiceItem;

public interface InvoiceItemServiceInterface {
	
	InvoiceItem findOne(Integer id);
	
	InvoiceItem save(InvoiceItem i);
	
	void remove(Integer id);
	
	InvoiceItem findByQuantity(String name);
	
	InvoiceItem findByDiscount(double d);

	InvoiceItem findByUnit_price(double u);

	InvoiceItem findByPDV_base(double pdv_b);
	
	InvoiceItem findByPDV_amount(double pdv_a);

	InvoiceItem findByTotal_amount(double a);

//	InvoiceItem findByService(Services service);
	
	List<InvoiceItem> findAll();
	 ResponseEntity report(Integer id);
}
