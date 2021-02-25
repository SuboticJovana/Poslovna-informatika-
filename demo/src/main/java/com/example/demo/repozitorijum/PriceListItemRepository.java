package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PriceListItem;

public interface PriceListItemRepository extends JpaRepository<PriceListItem, Integer>{

	PriceListItem findByPrice(String price);
}
