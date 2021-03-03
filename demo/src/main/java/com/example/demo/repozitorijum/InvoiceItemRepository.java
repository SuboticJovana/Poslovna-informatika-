package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InvoiceItem;
import com.example.demo.model.Services;


public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer>{

	InvoiceItem findByQuantity(String name);
	
	InvoiceItem findByDiscount(double d);

	InvoiceItem findByUnit_price(double u);

	InvoiceItem findByPDV_base(double pdv_b);
	
	InvoiceItem findByPDV_amount(double pdv_a);

	InvoiceItem findByTotal_amount(double a);

	InvoiceItem findByService(Services service);
}
