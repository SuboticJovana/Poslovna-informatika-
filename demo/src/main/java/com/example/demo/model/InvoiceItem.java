package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_items")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="quantity", unique=false, nullable=false)
	private  double quantity;
	
	@Column(name="discount", unique=false, nullable=false)
	private  double discount;

	@Column(name="unit_price", unique=false, nullable=false)
	private  double unit_price;

	//pdv stopa veza ili atribut ? 
	
	@Column(name="PDV_base", unique=false, nullable=false)
	private  double PDV_base;

	@Column(name="quantity", unique=false, nullable=false)
	private  double PDV_amount;

	@Column(name="total_amount", unique=false, nullable=false)
	private  double total_amount;

//	@ManyToOne faktura
//	@JoinColumn(name="invoice_id", referencedColumnName="id", nullable=false)
//	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name="service_id", referencedColumnName="roba_id", nullable=false)
	private RobaUsluga usluga;

	public InvoiceItem() {
		
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

//	public Invoice getInvoice() {
//		return invoice;
//	}
//
//	public void setInvoice(Invoice invoice) {
//		this.invoice = invoice;
//	}

	public RobaUsluga getUsluga() {
		return usluga;
	}

	public void setUsluga(RobaUsluga usluga) {
		this.usluga = usluga;
	}

	
}
