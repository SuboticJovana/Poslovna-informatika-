package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.Invoice;

public class InvoiceDTO {

	private Integer id;
	private Integer invoice_number;
	private Date date_invoice;
	private Date date_currency;
	private Double total_base;
	private Double total_amount;
	private Double total_pdv;
	private String status;
	
	public InvoiceDTO() {
		
	}
	public InvoiceDTO(Integer id, Integer invoice_number, Date date_invoice, Date date_currency, Double total_base,
			Double total_amount, Double total_pdv, String status) {
		super();
		this.id = id;
		this.invoice_number = invoice_number;
		this.date_invoice = date_invoice;
		this.date_currency = date_currency;
		this.total_base = total_base;
		this.total_amount = total_amount;
		this.total_pdv = total_pdv;
		this.status=status;
	}
	public InvoiceDTO(Invoice item) {
		// TODO Auto-generated constructor stub
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
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public Double getTotal_pdv() {
		return total_pdv;
	}
	public void setTotal_pdv(Double total_pdv) {
		this.total_pdv = total_pdv;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
