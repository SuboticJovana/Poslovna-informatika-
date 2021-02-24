package com.example.demo.model;

import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="preduzeca")
public class Preduzece implements Serializable {


	private static final long serialVersionUID = 6153112187370900486L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="preduzece_id", unique=true, nullable=false)
	private Integer preduzece_id;
	
	@Column(name="nazivPreduzeca",unique=false,nullable=false)
	private String nazivPreduzeca;
	
	@Column(name="adresa", unique=false, nullable=false)
	private String adresa;
	
	@Column(name="telefon", unique=false, nullable=false)
	private String telefon;
	
	@Column(name="fax", unique=false, nullable=false)
	private String fax;

	public Preduzece(Integer preduzece_id,String nazivPreduzeca, String adresa, String telefon, String fax) {
		super();
		this.preduzece_id = preduzece_id;
		this.nazivPreduzeca=nazivPreduzeca;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
	}

	public Integer getPreduzece_id() {
		return preduzece_id;
	}

	public void setPreduzece_id(Integer preduzece_id) {
		this.preduzece_id = preduzece_id;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
}
