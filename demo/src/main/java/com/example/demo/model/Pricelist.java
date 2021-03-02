package com.example.demo.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pricelists")
public class Pricelist implements Serializable {


	private static final long serialVersionUID = -8368749296479586744L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="pricelist_id", unique=true, nullable=false)
	private Integer pricelist_id;
	
	@Column(name="date_from", unique=false, nullable=false)
	private Date date_from;
	
	@Column(name="date_to", unique=false, nullable=false)
	private Date date_to;
	
	@Column(name="percentage", unique=false, nullable=false)
	private Integer percentage;
	
	@Column(name="total_price", unique=false, nullable=false)
	private Integer total_price;
		
	
	public Pricelist() {
		
	}
	public Pricelist(Integer pricelist_id, Date date_from, Date date_to, Integer percentage, Integer total_price) {
		super();
		this.pricelist_id = pricelist_id;
		this.date_from = date_from;
		this.date_to = date_to;
		this.percentage = percentage;
		this.total_price = total_price;
	}

	public Integer getPricelist_id() {
		return pricelist_id;
	}

	public void setPricelist_id(Integer pricelist_id) {
		this.pricelist_id = pricelist_id;
	}

	public Date getDate_from() {
		return date_from;
	}

	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}

	public Date getDate_to() {
		return date_to;
	}

	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Integer getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}

	

	
	
}

