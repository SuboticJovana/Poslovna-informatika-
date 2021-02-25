package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partners")
public class Partner implements Serializable{
	
	private static final long serialVersionUID = -5652339993553733589L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="partner_id", unique=true, nullable=false)
	private Integer partner_id;
	
	@Column(name="partner_name", unique=false, nullable=false)
	private String partner_name;
	
	@Column(name="address", unique=false, nullable=false)
	private String address;
	
	@Column(name="phone_number", unique=false, nullable=false)
	private String phone_number;
	
	@Column(name="fax", unique=false, nullable=false)
	private String fax;
	
	@Column(name="email", unique=false, nullable=false)
	private String email;
	
	@Column(name="type_of_partner", unique=false, nullable=false )
	@Enumerated(EnumType.ORDINAL)
	private TypeOfPartner type_of_partner;
	
	@ManyToOne
	@JoinColumn(name="city_id", referencedColumnName="city_id", nullable=false)
	 private City city;
	
	@ManyToOne
	@JoinColumn(name="preduzece_id", referencedColumnName="preduzece_id", nullable=false)
	 private Preduzece company;
	
//	Veza ka fakturi
	
	public Partner() {
		
	}

	public Integer getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}

	public String getPartner_name() {
		return partner_name;
	}

	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TypeOfPartner getType_of_partner() {
		return type_of_partner;
	}

	public void setType_of_partner(TypeOfPartner type_of_partner) {
		this.type_of_partner = type_of_partner;
	}

	public Preduzece getCompany() {
		return company;
	}

	public void setCompany(Preduzece company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
