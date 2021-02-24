package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;

import com.example.demo.model.Cenovnik;

public class CenovnikDTO implements Serializable {


	private static final long serialVersionUID = 5407660723734698041L;
	
	private int cenovnik_id;
	private Date datum_od;
	private Date datum_do;
	private int procenat;
	private int ukupna_cena;
	public CenovnikDTO(int cenovnik_id, Date datum_od, Date datum_do, int procenat, int ukupna_cena) {
		super();
		this.cenovnik_id = cenovnik_id;
		this.datum_od = datum_od;
		this.datum_do = datum_do;
		this.procenat = procenat;
		this.ukupna_cena = ukupna_cena;
	}
	public CenovnikDTO(Cenovnik c) {
		// TODO Auto-generated constructor stub
	}
	public CenovnikDTO() {
		super();
	}
	public int getCenovnik_id() {
		return cenovnik_id;
	}
	public void setCenovnik_id(int cenovnik_id) {
		this.cenovnik_id = cenovnik_id;
	}
	public Date getDatum_od() {
		return datum_od;
	}
	public void setDatum_od(Date datum_od) {
		this.datum_od = datum_od;
	}
	public Date getDatum_do() {
		return datum_do;
	}
	public void setDatum_do(Date datum_do) {
		this.datum_do = datum_do;
	}
	public int getProcenat() {
		return procenat;
	}
	public void setProcenat(int procenat) {
		this.procenat = procenat;
	}
	public int getUkupna_cena() {
		return ukupna_cena;
	}
	public void setUkupna_cena(int ukupna_cena) {
		this.ukupna_cena = ukupna_cena;
	}
	
	
	
}
