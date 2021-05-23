package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Enterprise;
import com.example.demo.model.Invoice;
import com.example.demo.repozitorijum.InvoiceRepository;
@Service
public class InvoiceService implements InvoiceServiceInterface{

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice findOne(Integer invoice_id) {
		return invoiceRepository.getOne(invoice_id);
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
		 invoiceRepository.deleteById(invoice_id);
		 return new Invoice();
	}

	@Override
	public List<Invoice> findByEnterprise(Enterprise enterprise) {
		return invoiceRepository.findByEnterprise(enterprise);
	}

}
