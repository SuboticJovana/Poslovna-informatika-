package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InvoiceItem;
import com.example.demo.model.RobaUsluga;
import com.example.demo.repozitorijum.InvoiceItemRepository;

@Service
public class InvoiceItemService implements InvoiceItemServiceInterface{

	@Autowired
	private InvoiceItemRepository repository;
	
	@Override
	public InvoiceItem findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public InvoiceItem save(InvoiceItem i) {
		return repository.save(i);
	}

	@Override
	public void remove(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public InvoiceItem findByQuantity(String name) {
		return repository.findByQuantity(name);
	}

	@Override
	public InvoiceItem findByDiscount(double d) {
		return repository.findByDiscount(d);
	}

	@Override
	public InvoiceItem findByUnit_price(double u) {
		return null;
	}

	@Override
	public InvoiceItem findByPDV_base(double pdv_b) {
		return null;
	}

	@Override
	public InvoiceItem findByPDV_amount(double pdv_a) {
		return repository.findByPDV_amount(pdv_a);
	}

	@Override
	public InvoiceItem findByTotal_amount(double a) {
		return repository.findByTotal_amount(a);
	}

	@Override
	public InvoiceItem findByRobaUsluga(RobaUsluga service) {
		return repository.findByRobaUsluga(service);
	}

	@Override
	public List<InvoiceItem> findAll() {
		return repository.findAll();
	}
	
	

}
