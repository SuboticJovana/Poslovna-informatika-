package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Preduzece;
import com.example.demo.repozitorijum.PreduzeceRepozitorijum;

public class PreduzeceServis implements PreduzeceServisInterfejs {
@Autowired
PreduzeceRepozitorijum preduzeceRepozitorijum;

	@Override
	public Preduzece findOne(Integer preduzece_id) {
		return  null;
	}

	@Override
	public List<Preduzece> findAll() {
		return preduzeceRepozitorijum.findAll();
		}

	@Override
	public Preduzece save(Preduzece preduzece) {
		return preduzeceRepozitorijum.save(preduzece);
	}

	@Override
	public void remove(Integer preduzece_id) {
		preduzeceRepozitorijum.deleteById(preduzece_id);
		
	}

	@Override
	public Preduzece findByNaziv(String naziv) {
		// TODO Auto-generated method stub
		return preduzeceRepozitorijum.findByNaziv(naziv);
	}

}
