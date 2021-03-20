package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Enterprise;

@SuppressWarnings("serial")
public class EnterpriseDTO implements Serializable {

	
	private int enteprise_id;
	private String nameEnterprise;
	private String address;
	private String phone;
	private String fax;
	
	public EnterpriseDTO(int enteprise_id, String nameEnterprise, String address, String phone, String fax) {
		super();
		this.enteprise_id = enteprise_id;
		this.nameEnterprise = nameEnterprise;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
	}
	public EnterpriseDTO(Enterprise enterprise) {
		this(enterprise.getEnterprise_id(),enterprise.getNameEnterprise(), enterprise.getAddress(),enterprise.getPhone(),enterprise.getFax());
	}
	
	public EnterpriseDTO() {
		
	}
	
	public int getEnteprise_id() {
		return enteprise_id;
	}
	public void setEnteprise_id(int enteprise_id) {
		this.enteprise_id = enteprise_id;
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


