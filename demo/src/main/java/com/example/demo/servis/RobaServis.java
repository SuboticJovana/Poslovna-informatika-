package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.RobaUsluga;
import com.example.demo.repozitorijum.RobaRepozitorijum;

public class RobaServis implements RobaServisInterfejs {
	
	@Autowired
	RobaRepozitorijum robaRepozitorijum;

	@Override
	public RobaUsluga findOne(Integer roba_id) {
		return null;
		//return robaRepozitorijum.findOne(roba_id);
	}

	@Override
	public List<RobaUsluga> findAll() {
		return robaRepozitorijum.findAll();
	}

	@Override
	public RobaUsluga save(RobaUsluga robaUsluga) {
		return robaRepozitorijum.save(robaUsluga);
	}

	@Override
	public void remove(Integer roba_id) {
		robaRepozitorijum.deleteById(roba_id);
		
	}

	@Override
	public RobaUsluga findByNaziv(String naziv) {
		return robaRepozitorijum.findByNaziv(naziv);
	}

	@Override
	public RobaUsluga findByOpis(String opis) {
	return null;	
	//return robaRepozitorijum.findByOpis(opis);
}

}
