package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InvoiceItem;
import com.example.demo.model.Services;


public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer>{

	InvoiceItem findByQuantity(String quantity);
	
	InvoiceItem findByDiscount(double d);

	InvoiceItem findByUnitPrice(double u);

	InvoiceItem findByPDVBase(double pdv_b);
	
	InvoiceItem findByPDVAmount(double pdv_a);

	InvoiceItem findByTotalAmount(double a);

//	InvoiceItem findByService(Services services);
}
