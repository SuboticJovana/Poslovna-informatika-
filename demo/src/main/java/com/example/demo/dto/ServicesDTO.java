package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Services;

public class ServicesDTO implements Serializable {

	private static final long serialVersionUID = -8939650811392798052L;
	private int services_id;
	private String name;
	private String description;
	private Boolean goods;
	public ServicesDTO(int services_id, String name, String description, Boolean goods) {
		super();
		this.services_id = services_id;
		this.name = name;
		this.description = description;
		this.goods = goods;
	}
	public ServicesDTO(Services s) {
		this(s.getService_id(), s.getName(), s.getDescription(), s.getGoods());
	}
	public int getServices_id() {
		return services_id;
	}
	public void setServices_id(int services_id) {
		this.services_id = services_id;
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
	
	

}
