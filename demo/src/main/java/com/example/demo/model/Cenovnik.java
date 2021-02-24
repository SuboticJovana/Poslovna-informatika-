package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cenovnici")
public class Cenovnik implements Serializable {


	private static final long serialVersionUID = -4753381481459052650L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="cenovnik_id", unique=true, nullable=false)
	private Integer cenovnik_id;
	
	@Column(name="datum_od", unique=false, nullable=false)
	private Date datum_od;
	
	@Column(name="datum_do", unique=false, nullable=false)
	private Date datum_do;
	
	@Column(name="procenat", unique=false, nullable=false)
	private Integer procenat;
	
	@Column(name="ukupna_cena", unique=false, nullable=false)
	private Integer ukupna_cena;

	public Cenovnik(Integer cenovnik_id, Date datum_od, Date datum_do, Integer procenat,
			Integer ukupna_cena) {
		super();
		this.cenovnik_id = cenovnik_id;
		this.datum_od = datum_od;
		this.datum_do = datum_do;
		this.procenat = procenat;
		this.ukupna_cena = ukupna_cena;
	}

	public Integer getCenovnik_id() {
		return cenovnik_id;
	}

	public void setCenovnik_id(Integer cenovnik_id) {
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

	public Integer getProcenat() {
		return procenat;
	}

	public void setProcenat(Integer procenat) {
		this.procenat = procenat;
	}

	public Integer getUkupna_cena() {
		return ukupna_cena;
	}

	public void setUkupna_cena(Integer ukupna_cena) {
		this.ukupna_cena = ukupna_cena;
	}
	
	
}
