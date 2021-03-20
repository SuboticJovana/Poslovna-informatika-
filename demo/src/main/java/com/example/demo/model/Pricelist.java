package com.example.demo.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="pricelists")
public class Pricelist implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="pricelist_id", unique=true, nullable=false)
	private Integer pricelist_id;
	
	@Column(name="date_from", unique=false, nullable=false)
	private Date dateFrom;
	
//	@Column(name="date_to", unique=false, nullable=false)
//	private Date dateTo;
	
//	@Column(name="percentage", unique=false, nullable=false)
//	private Integer percentage;
	
//	@Column(name="total_price", unique=false, nullable=false)
//	private Integer totalPrice;

	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="pricelist")
	private Set<PriceListItem> items = new HashSet<PriceListItem>();
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="enterprise_id", referencedColumnName="enterprise_id", nullable=false)
	private Enterprise enterprise;
	
	public Pricelist() {
		
	}
	public Pricelist(Integer pricelist_id, Date date_from
//			Date date_to,
//			Integer percentage, Integer total_price
			)
	{
		super();
		this.pricelist_id = pricelist_id;
		this.dateFrom = date_from;
//		this.dateTo = date_to;
//		this.percentage = percentage;
//		this.totalPrice = total_price;
	}

	public Pricelist(Integer pricelist_id, Date dateFrom, Enterprise enterprise ) {
		super();
		this.pricelist_id = pricelist_id;
		this.dateFrom = dateFrom;
		this.enterprise = enterprise;
	}
	
	
	public Integer getPricelist_id() {
		return pricelist_id;
	}

	public Pricelist(Integer pricelist_id, Date dateFrom, Set<PriceListItem> items, Enterprise enterprise) {
		super();
		this.pricelist_id = pricelist_id;
		this.dateFrom = dateFrom;
		this.items = items;
		this.enterprise = enterprise;
	}



	public void setPricelist_id(Integer pricelist_id) {
		this.pricelist_id = pricelist_id;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

//	public Date getDateTo() {
//		return dateTo;
//	}
//
//	public void setDateTo(Date dateTo) {
//		this.dateTo = dateTo;
//	}

//	public Integer getPercentage() {
//		return percentage;
//	}
//
//	public void setPercentage(Integer percentage) {
//		this.percentage = percentage;
//	}
//
//	public Integer getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(Integer totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	public Set<PriceListItem> getItems() {
		return items;
	}
	public void setItems(Set<PriceListItem> items) {
		this.items = items;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
	
}

