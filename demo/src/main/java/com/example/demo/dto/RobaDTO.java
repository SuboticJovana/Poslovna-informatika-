package com.example.demo.dto;

import java.io.Serializable;

public class RobaDTO implements Serializable{

	
	private static final long serialVersionUID = -8005273895019664223L;
	
	private int roba_id;
	private String naziv;
	private String opis;
	private Boolean roba;
	public RobaDTO(int roba_id, String naziv, String opis, Boolean roba) {
		super();
		this.roba_id = roba_id;
		this.naziv = naziv;
		this.opis = opis;
		this.roba = roba;
	}
	public int getRoba_id() {
		return roba_id;
	}
	public void setRoba_id(int roba_id) {
		this.roba_id = roba_id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Boolean getRoba() {
		return roba;
	}
	public void setRoba(Boolean roba) {
		this.roba = roba;
	}
	
	
	
}
