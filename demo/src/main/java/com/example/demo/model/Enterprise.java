package com.example.demo.model;


import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enterprises")
public class Enterprise implements Serializable {


	private static final long serialVersionUID = -7823756286553586902L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="enterprise_id", unique=true, nullable=false)
	private Integer enterprise_id;
	
	@Column(name="nameEnterprise",unique=false,nullable=false)
	private String nameEnterprise;
	
	@Column(name="address", unique=false, nullable=false)
	private String address;
	
	@Column(name="phone", unique=false, nullable=false)
	private String phone;
	
	@Column(name="fax", unique=false, nullable=false)
	private String fax;

	public Enterprise(Integer enterprise_id, String nameEnterprise, String address, String phone, String fax) {
		super();
		this.enterprise_id = enterprise_id;
		this.nameEnterprise = nameEnterprise;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
	}

	public Enterprise() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEnterprise_id() {
		return enterprise_id;
	}

	public void setEnterprise_id(Integer enterprise_id) {
		this.enterprise_id = enterprise_id;
	}

	public String getNameEnterprise() {
		return nameEnterprise;
	}

	public void setNameEnterprise(String nameEnterprise) {
		this.nameEnterprise = nameEnterprise;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	
	
	
}
