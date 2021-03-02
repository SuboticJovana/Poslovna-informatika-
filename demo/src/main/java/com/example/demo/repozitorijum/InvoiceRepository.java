package com.example.demo.repozitorijum;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	Invoice findByNumberInvoice(Integer number_invoice);
	Invoice findByDateInvoice(Date date_invoice);
	Invoice findByDateCurrency(Date date_currency);
	Invoice findByTotalPdv(Double total_pdv);
	
	
}
