package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="price_list_items")
public class PriceListItem implements Serializable {
	
	private static final long serialVersionUID = -5652339993553733589L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="price_list_item_id", unique=true, nullable=false)
	private Integer price_list_item_id;
	
	@Column(name="price", unique=false, nullable=false)
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="cenovnik_id", referencedColumnName="cenovnik_id", nullable=false)
	 private Cenovnik pricelist;
	
//	Veza ka robi
	
	public PriceListItem() {
		
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

	public Cenovnik getPricelist() {
		return pricelist;
	}

	public void setPricelist(Cenovnik pricelist) {
		this.pricelist = pricelist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
