package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.PriceListItem;
import com.example.demo.repozitorijum.PriceListItemRepository;

public class PriceListItemService implements PriceListItemServiceInterface{
	
	@Autowired
	PriceListItemRepository priceListItemRepository;

	@Override
	public PriceListItem findOne(Integer price_list_item_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceListItem save(PriceListItem priceListItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceListItem remove(PriceListItem price_list_item_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PriceListItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
