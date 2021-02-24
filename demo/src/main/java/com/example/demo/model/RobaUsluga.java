package com.example.demo.model;

import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="robeusluge")
public class RobaUsluga implements Serializable {


	private static final long serialVersionUID = -630242451154859327L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="roba_id", unique=true, nullable=false)
	private Integer roba_id;
	
	@Column(name="naziv", unique=false, nullable=false)
	private String naziv;
	
	@Column(name="opis", unique=false, nullable=false)
	private String opis;
	
	@Column(name="roba", unique=false, nullable=false)
	private Boolean roba;

	public RobaUsluga(Integer roba_id, String naziv, String opis, Boolean roba) {
		super();
		this.roba_id = roba_id;
		this.naziv = naziv;
		this.opis = opis;
		this.roba = roba;
	}

	public Integer getRoba_id() {
		return roba_id;
	}

	public void setRoba_id(Integer roba_id) {
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
