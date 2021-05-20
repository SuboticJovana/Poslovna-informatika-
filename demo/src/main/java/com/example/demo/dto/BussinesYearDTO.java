package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class BussinesYearDTO implements Serializable{
	
	private Integer idYear;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	
//	private Integer numberofYear;
	
//	private Boolean closed;

	
	public BussinesYearDTO() {
		super();
	}

	public Integer getIdYear() {
		return idYear;
	}

	public void setIdYear(Integer idYear) {
		this.idYear = idYear;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
//	public Integer getNumberofYear() {
//		return numberofYear;
//	}
//
//	public void setNumberofYear(Integer numberofYear) {
//		this.numberofYear = numberofYear;
//	}
//
//	public Boolean getClosed() {
//		return closed;
//	}
//
//	public void setClosed(Boolean closed) {
//		this.closed = closed;
//	}
	
	

}
