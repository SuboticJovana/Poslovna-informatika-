package com.example.demo.repozitorijum;

import com.example.demo.model.RobaUsluga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobaRepozitorijum extends JpaRepository<RobaUsluga,Integer>{

	RobaUsluga findByNaziv(String naziv);
	 
	RobaUsluga findByOpis(String opis);
	
	RobaUsluga findByRoba(Boolean roba);
}
