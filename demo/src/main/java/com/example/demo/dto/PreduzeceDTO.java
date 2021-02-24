package com.example.demo.dto;

import java.io.Serializable;

public class PreduzeceDTO implements Serializable {
	
	
	private static final long serialVersionUID = 8372157753123883468L;
	
	private int preduzece_id;
	private String nazivPreduzeca;
	private String adresa;
	private String telefon;
	private String fax;
	public PreduzeceDTO(int preduzece_id, String nazivPreduzeca, String adresa, String telefon, String fax) {
		super();
		this.preduzece_id = preduzece_id;
		this.nazivPreduzeca = nazivPreduzeca;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
	}
	public int getPreduzece_id() {
		return preduzece_id;
	}
	public void setPreduzece_id(int preduzece_id) {
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
