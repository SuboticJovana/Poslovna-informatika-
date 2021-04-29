package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.City;
import com.example.demo.model.User;

public class UserDTO implements Serializable{
	
	private Integer user_id;
	
	private String username;
	
	private String password;
	
	private Long enterprise_id;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String username,String password ) {
		this.username= username;
		this.password=password;

	}
	
	public UserDTO(Integer user_id, String username,String password,Long enterprise_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.enterprise_id = enterprise_id;
	}
	public UserDTO(Integer user_id, String username,String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
	
	public UserDTO(User u) {
		this(u.getUser_id(), u.getUsername(), u.getPassword());
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getEnterprise_id() {
		return enterprise_id;
	}

	public void setEnterprise_id(Long long1) {
		this.enterprise_id = long1;
	}

	

}
