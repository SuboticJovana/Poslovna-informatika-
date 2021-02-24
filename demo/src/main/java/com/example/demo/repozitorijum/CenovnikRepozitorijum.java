package com.example.demo.repozitorijum;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cenovnik;
public interface CenovnikRepozitorijum extends JpaRepository<Cenovnik, Integer> {

	Cenovnik findByDatumOd(Date datum_od);
	
	Cenovnik findByDatumDo(Date datum_do);
	
	Cenovnik findByProcenat(int procenat);
	
	Cenovnik findByUkupnaCena(int ukupna_cena);
}

