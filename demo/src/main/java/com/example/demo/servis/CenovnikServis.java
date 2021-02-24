package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Cenovnik;
import com.example.demo.repozitorijum.CenovnikRepozitorijum;

public class CenovnikServis implements CenovnikServisInterfejs {
	
	@Autowired
	CenovnikRepozitorijum cenovnikRepozitorijum;
	
	@Override
	public Cenovnik findOne(Integer cenovnik_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cenovnik> findAll() {
		// TODO Auto-generated method stub
		return cenovnikRepozitorijum.findAll();
	}

	@Override
	public Cenovnik save(Cenovnik cenovnik) {
		return cenovnikRepozitorijum.save(cenovnik);
	}

	@Override
	public void remove(Integer cenovnik_id) {
		cenovnikRepozitorijum.deleteById(cenovnik_id);
		
	}

	@Override
	public Cenovnik findByUkupnaCena(Integer ukupna_cena) {
		// TODO Auto-generated method stub
		return cenovnikRepozitorijum.findByUkupnaCena(ukupna_cena);
	}

}
