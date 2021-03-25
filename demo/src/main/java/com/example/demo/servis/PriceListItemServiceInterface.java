package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.PriceListItem;
import com.example.demo.model.Pricelist;

public interface PriceListItemServiceInterface {
	
	PriceListItem findOne(Long price_list_item_id);
	
	PriceListItem save(PriceListItem priceListItem);
	
	void remove(Long price_list_item_id);
	
	List<PriceListItem> findAll();
	
	PriceListItem findByCena(Double price);
	
	List<PriceListItem> findByPricelist(Pricelist pricelist);

}
