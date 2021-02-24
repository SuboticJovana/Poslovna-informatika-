package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.RobaUsluga;

public interface RobaServisInterfejs {

	RobaUsluga findOne(Integer roba_id);
	
	List<RobaUsluga> findAll();
	
	RobaUsluga save(RobaUsluga robaUsluga);
	
	void remove(Integer roba_id);
	
	RobaUsluga findByNaziv(String naziv);
	
	RobaUsluga findByOpis(String opis);
}
