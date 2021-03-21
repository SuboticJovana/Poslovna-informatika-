package com.example.demo.repozitorijum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PriceListItem;

public interface PriceListItemRepository extends JpaRepository<PriceListItem, Long>{

	PriceListItem findByPrice(double price);
	
	List<PriceListItem> findAll();
}
