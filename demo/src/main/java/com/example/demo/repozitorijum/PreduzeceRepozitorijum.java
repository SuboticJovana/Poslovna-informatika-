package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Preduzece;

public interface PreduzeceRepozitorijum extends JpaRepository<Preduzece,Integer> {
	
	Preduzece findByNaziv(String nazivPreduzeca);
	
	Preduzece findByAdresa(String adresa);
	
	Preduzece findByTelefon(String telefon);
	
	Preduzece findByFax(String fax);
}
