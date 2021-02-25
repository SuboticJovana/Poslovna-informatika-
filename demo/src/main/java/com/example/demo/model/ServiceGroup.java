package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="service_group")
public class ServiceGroup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique=false, nullable=false)
	private String  name;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="service_group")
	private Set<RobaUsluga> services = new HashSet<RobaUsluga>();

	@ManyToOne
	@JoinColumn(name="pdv_category_id", referencedColumnName="id", nullable=false)
	private PDVCategory PDVCategory;

	@ManyToOne
	@JoinColumn(name="firm_id", referencedColumnName="preduzece_id", nullable=false)
	private Preduzece firm;
	
	public ServiceGroup() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RobaUsluga> getServices() {
		return services;
	}

	public void setServices(Set<RobaUsluga> services) {
		this.services = services;
	}

	public PDVCategory getPDVCategory() {
		return PDVCategory;
	}

	public void setPDVCategory(PDVCategory pDVCategory) {
		PDVCategory = pDVCategory;
	}

	public Preduzece getFirm() {
		return firm;
	}

	public void setFirm(Preduzece firm) {
		this.firm = firm;
	}
	
}
