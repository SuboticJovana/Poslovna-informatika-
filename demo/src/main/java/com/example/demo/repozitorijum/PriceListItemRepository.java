package com.example.demo.repozitorijum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PriceListItem;
import com.example.demo.model.Pricelist;

public interface PriceListItemRepository extends JpaRepository<PriceListItem, Long>{

	PriceListItem findByPrice(double price);
	
	List<PriceListItem> findAll();
	
	List<PriceListItem> findByPricelist(Pricelist pricelist);
}
