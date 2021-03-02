package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="invoice_number", unique=false, nullable=false)
	private  Integer invoice_number;
	
	@Column(name="date_invoice", unique=false, nullable=false)
	private  Date date_invoice;
	
	@Column(name="date_currency", unique=false, nullable=false)
	private Date  date_currency;
	
	@Column(name="total_base", unique=false, nullable=false)
	private Double  total_base;
	
	@Column(name="total_pdv", unique=false, nullable=false)
	private Double  total_pdv;
	
	@Column(name="total_amount", unique=false, nullable=false)
	private Double  total_amount;
	
	@Column(name="status", unique=false, nullable=false)
	private String  status;
	
public Invoice() {
	
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getInvoice_number() {
	return invoice_number;
}

public void setInvoice_number(Integer invoice_number) {
	this.invoice_number = invoice_number;
}

public Date getDate_invoice() {
	return date_invoice;
}

public void setDate_invoice(Date date_invoice) {
	this.date_invoice = date_invoice;
}

public Date getDate_currency() {
	return date_currency;
}

public void setDate_currency(Date date_currency) {
	this.date_currency = date_currency;
}

public Double getTotal_base() {
	return total_base;
}

public void setTotal_base(Double total_base) {
	this.total_base = total_base;
}

public Double getTotal_pdv() {
	return total_pdv;
}

public void setTotal_pdv(Double total_pdv) {
	this.total_pdv = total_pdv;
}

public Double getTotal_amount() {
	return total_amount;
}

public void setTotal_amount(Double total_amount) {
	this.total_amount = total_amount;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


}
