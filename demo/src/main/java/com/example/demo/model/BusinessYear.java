package com.example.demo.model;

import java.io.Serializable;
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
@Table(name = "businessyear")
public class BusinessYear implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6351610115262789313L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idYear", nullable = false, unique = true)
	private Integer idYear;
	
	@Column(name = "numberofYear", nullable = false, unique = true)
	private Integer numberofYear;
	
	@Column(name = "closed", nullable = false)
	private Boolean closed;

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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}		
	
	

}
