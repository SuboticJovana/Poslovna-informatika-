package com.example.demo.servis;

import java.util.List;

import com.example.demo.model.Preduzece;

public interface PreduzeceServisInterfejs {
	
	Preduzece findOne(Integer preduzece_id);
	
	List <Preduzece> findAll();
	
	Preduzece save(Preduzece preduzece);
	
	void remove(Integer preduzece_id);
	
	Preduzece findByNaziv(String naziv);

}
