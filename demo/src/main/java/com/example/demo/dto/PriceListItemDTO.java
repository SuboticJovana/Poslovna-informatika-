package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.PriceListItem;

@SuppressWarnings("serial")
public class PriceListItemDTO implements Serializable{

	private Integer price_list_item_id;
	
	private Double price;
	
	public PriceListItemDTO() {
		super();
	}
	
	public PriceListItemDTO(int price_list_item_id, double price) {
		super();
		this.price_list_item_id = price_list_item_id;
		this.price = price;
	}
	
	public PriceListItemDTO(PriceListItem pi) {
		this(pi.getPrice_list_item_id(), pi.getPrice());
	}

	public Integer getPrice_list_item_id() {
		return price_list_item_id;
	}

	public void setPrice_list_item_id(Integer price_list_item_id) {
		this.price_list_item_id = price_list_item_id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
