package com.example.demo.model;

import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class Services implements Serializable {


	private static final long serialVersionUID = -186152084960632736L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="service_id", unique=true, nullable=false)
	private Integer service_id;
	
	@Column(name="name", unique=false, nullable=false)
	private String name;
	
	@Column(name="description", unique=false, nullable=false)
	private String description;
	
	@Column(name="goods", unique=false, nullable=false)
	private Boolean goods;

	@ManyToOne
	@JoinColumn(name="groupserv_id", referencedColumnName="id", nullable=false)
	private ServiceGroup firm;
	
	@ManyToOne
	@JoinColumn(name="unitmea_id", referencedColumnName="id", nullable=false)
	private UnitOfMeasure unit;
	
	public Services(Integer service_id, String name, String description, Boolean goods) {
		super();
		this.service_id = service_id;
		this.name = name;
		this.description = description;
		this.goods = goods;
	}

	public Services() {
		// TODO Auto-generated constructor stub
	}

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getGoods() {
		return goods;
	}

	public void setGoods(Boolean goods) {
		this.goods = goods;
	}

	public ServiceGroup getFirm() {
		return firm;
	}

	public void setFirm(ServiceGroup firm) {
		this.firm = firm;
	}

	public UnitOfMeasure getUnit() {
		return unit;
	}

	public void setUnit(UnitOfMeasure unit) {
		this.unit = unit;
	}

	
}

