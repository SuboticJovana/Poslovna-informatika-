package com.example.demo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BussinesYearDTO implements Serializable{
	
	private Integer idYear;
	
	private Integer numberofYear;
	
	private Boolean closed;

	
	public BussinesYearDTO() {
		super();
	}

	public Integer getIdYear() {
		return idYear;
	}

	public void setIdYear(Integer idYear) {
		this.idYear = idYear;
	}

	public Integer getNumberofYear() {
		return numberofYear;
	}

	public void setNumberofYear(Integer numberofYear) {
		this.numberofYear = numberofYear;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}
	
	

}
