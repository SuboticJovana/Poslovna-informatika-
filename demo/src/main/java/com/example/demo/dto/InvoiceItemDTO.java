package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.InvoiceItem;

public class InvoiceItemDTO implements Serializable{

	private Integer id;

	private  double quantity;

	private  double discount;

	private  double unitPrice;

	private  double PDVBase;

	private  double PDVAmount;

	private  double totalAmount;

	private ServicesDTO service;
	
	private Integer service_id;
	
	public InvoiceItemDTO() {
		super();
	}

	public InvoiceItemDTO(double quantity, double discount,double unit_price, double PDV_base,double PDV_amount,double total_amount,ServicesDTO service  ) {
		this.quantity=quantity;
		this.discount=discount;
		this.unitPrice=unit_price;
		this.PDVBase=PDV_base;
		this.PDVAmount=PDV_amount;
		this.totalAmount=total_amount;
		this.service=service;
	}
	public InvoiceItemDTO(double quantity, double discount,double unit_price, double PDV_base,double PDV_amount,double total_amount,Integer service_id  ) {
		this.quantity=quantity;
		this.discount=discount;
		this.unitPrice=unit_price;
		this.PDVBase=PDV_base;
		this.PDVAmount=PDV_amount;
		this.totalAmount=total_amount;
		this.service_id=service_id;
	}

	
	public InvoiceItemDTO(Integer id, double quantity, double discount,double unit_price, double PDV_base,double PDV_amount,double total_amount,ServicesDTO service  ) {
		super();
		this.id = id;
		this.quantity=quantity;
		this.discount=discount;
		this.unitPrice=unit_price;
		this.PDVBase=PDV_base;
		this.PDVAmount=PDV_amount;
		this.totalAmount=total_amount;
		this.service=service;
	}
	
	public InvoiceItemDTO(InvoiceItem u) {
		this(u.getId(),u.getQuantity(), u.getDiscount(), u.getUnitPrice(), u.getPDVBase(), u.getPDVAmount(), u.getTotalAmount(), new ServicesDTO(u.getServices()));
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

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getPDVBase() {
		return PDVBase;
	}

	public void setPDVBase(double pDVBase) {
		PDVBase = pDVBase;
	}

	public double getPDVAmount() {
		return PDVAmount;
	}

	public void setPDVAmount(double pDVAmount) {
		PDVAmount = pDVAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ServicesDTO getService() {
		return service;
	}

	public void setService(ServicesDTO service) {
		this.service = service;
	}

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	
	

}
