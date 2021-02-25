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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pdv_category")
public class PDVCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique=false, nullable=false)
	private String  name;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="pdv_category")
	private Set<ServiceGroup> groups = new HashSet<ServiceGroup>();
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="pdv_category")
	private Set<PDVRate> rates = new HashSet<PDVRate>();
	
	public PDVCategory() {
		
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

	public Set<ServiceGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<ServiceGroup> groups) {
		this.groups = groups;
	}

	public Set<PDVRate> getRates() {
		return rates;
	}

	public void setRates(Set<PDVRate> rates) {
		this.rates = rates;
	}
	
}
