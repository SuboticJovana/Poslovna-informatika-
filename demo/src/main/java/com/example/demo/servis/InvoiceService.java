package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Invoice;
import com.example.demo.repozitorijum.InvoiceRepository;

public class InvoiceService implements InvoiceServiceInterface{

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice findOne(Integer invoice_id) {
		return null;
	}

	@Override
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}



	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice remove(Integer invoice_id) {
		return null;
	}

}
