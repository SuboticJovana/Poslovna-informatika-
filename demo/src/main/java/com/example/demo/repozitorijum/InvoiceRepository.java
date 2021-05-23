package com.example.demo.repozitorijum;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Enterprise;
import com.example.demo.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	Invoice findByNumber(Integer number_invoice);
	Invoice findByDate(Date date_invoice);
	Invoice findByDateCurrency(Date date_currency);
	Invoice findByTotalPdv(Double total_pdv);
	
	List<Invoice> findByEnterprise(Enterprise enterprise);

}
