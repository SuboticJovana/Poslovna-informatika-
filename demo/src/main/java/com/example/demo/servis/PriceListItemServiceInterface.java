package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.PriceListItem;

public interface PriceListItemServiceInterface {
	
	PriceListItem findOne(Integer price_list_item_id);
	
	PriceListItem save(PriceListItem priceListItem);
	
	PriceListItem remove(Integer price_list_item_id);
	
	List<PriceListItem> findAll();

}
