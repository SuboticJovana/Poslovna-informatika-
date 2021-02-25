package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.InvoiceItem;

public class InvoiceItemDTO implements Serializable{

	private Integer id;

	private  double quantity;

	private  double discount;

	private  double unit_price;

	private  double PDV_base;

	private  double PDV_amount;

	private  double total_amount;

	private RobaDTO usluga;
	
	public InvoiceItemDTO() {
		super();
	}

	public InvoiceItemDTO(double quantity, double discount,double unit_price, double PDV_base,double PDV_amount,double total_amount  ) {
		this.quantity=quantity;
		this.discount=discount;
		this.unit_price=unit_price;
		this.PDV_base=PDV_base;
		this.PDV_amount=PDV_amount;
		this.total_amount=total_amount;
		//
	}
	
	public InvoiceItemDTO(Integer id, double quantity, double discount,double unit_price, double PDV_base,double PDV_amount,double total_amount  ) {
		super();
		this.id = id;
		this.quantity=quantity;
		this.discount=discount;
		this.unit_price=unit_price;
		this.PDV_base=PDV_base;
		this.PDV_amount=PDV_amount;
		this.total_amount=total_amount;
	}
	
	public InvoiceItemDTO(InvoiceItem u) {
		this(u.getId(),u.getQuantity(), u.getDiscount(), u.getUnit_price(), u.getPDV_base(), u.getPDV_amount(), u.getTotal_amount());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public double getPDV_base() {
		return PDV_base;
	}

	public void setPDV_base(double pDV_base) {
		PDV_base = pDV_base;
	}

	public double getPDV_amount() {
		return PDV_amount;
	}

	public void setPDV_amount(double pDV_amount) {
		PDV_amount = pDV_amount;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public RobaDTO getUsluga() {
		return usluga;
	}

	public void setUsluga(RobaDTO usluga) {
		this.usluga = usluga;
	}
	
	

}
