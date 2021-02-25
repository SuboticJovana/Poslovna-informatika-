package com.example.demo.servis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RobaUsluga;
import com.example.demo.model.UnitOfMeasure;
import com.example.demo.repozitorijum.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureService implements UnitOfMeasureServiceInterface{

	@Autowired
	private UnitOfMeasureRepository repository;
	
	@Override
	public UnitOfMeasure findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public UnitOfMeasure save(UnitOfMeasure u) {
		return repository.save(u);
	}

	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public UnitOfMeasure findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public UnitOfMeasure findByShort_name(String sh_name) {
		return repository.findByShort_name(sh_name);
	}

	@Override
	public UnitOfMeasure findByRobaUsluga(RobaUsluga r) {
		return repository.findByRobaUsluga(r);
	}

	@Override
	public List<UnitOfMeasure> findAll() {
		return repository.findAll();
	}
	
}
