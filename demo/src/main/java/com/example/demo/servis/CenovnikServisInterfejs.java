package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Cenovnik;

public interface CenovnikServisInterfejs {
	
	Cenovnik findOne(Integer cenovnik_id);
	
	List<Cenovnik> findAll();
	
	Cenovnik save(Cenovnik cenovnik);
	
	void remove(Integer cenovnik_id);
	
	Cenovnik findByUkupnaCena(Integer ukupna_cena);

}
