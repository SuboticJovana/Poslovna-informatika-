package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Invoice;

public interface InvoiceServiceInterface {
	
	Invoice findOne(Integer invoice_id);
	
	Invoice save(Invoice invoice);
	
	Invoice remove(Integer invoice_id);
	
	List<Invoice> findAll();
}
