package com.example.demo.kontroler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.CenovnikDTO;
import com.example.demo.model.Cenovnik;
import com.example.demo.servis.CenovnikServisInterfejs;

@RestController
@RequestMapping("prodaja/cenovnici")
public class CenovnikKontroler {
	
	@Autowired 
	private CenovnikServisInterfejs cenovnikServis;
	
	@GetMapping
	public ResponseEntity<List<CenovnikDTO>> getCenovnik() {
	List<Cenovnik> cenovnici = cenovnikServis.findAll();
	List<CenovnikDTO> cenovnikDTO = new ArrayList<CenovnikDTO>();
	for (Cenovnik c : cenovnici) {
		cenovnikDTO.add(new CenovnikDTO(c));
	}
	return new ResponseEntity<List<CenovnikDTO>>(cenovnikDTO, HttpStatus.OK);

	}
	@GetMapping(value="/{id}")
	public ResponseEntity<CenovnikDTO> getCenovnik(@PathVariable("id") Integer id){
		Cenovnik cenovnik = cenovnikServis.findOne(id);
		if(cenovnik == null){
			return new ResponseEntity<CenovnikDTO>(HttpStatus.NOT_FOUND);
		}
		CenovnikDTO cenovnikDTO = new CenovnikDTO(cenovnik);
		return new ResponseEntity<CenovnikDTO>(cenovnikDTO, HttpStatus.OK);
	}
	@PostMapping(consumes="application/json")
	public ResponseEntity<CenovnikDTO> saveCenovnik(@RequestBody CenovnikDTO cDTO){
		//ispraviti
		Cenovnik cenovnik = new Cenovnik(null, null, null, null, null);
		cenovnik.setDatum_do(cDTO.getDatum_do());
		cenovnik.setDatum_od(cDTO.getDatum_od());
		cenovnik.setProcenat(cDTO.getProcenat());
		cenovnik.setUkupna_cena(cDTO.getUkupna_cena());
		
	



		cenovnikServis.save(cenovnik);
		CenovnikDTO cenovnikDTO = new CenovnikDTO(cenovnik);
		return new ResponseEntity<CenovnikDTO>(cenovnikDTO, HttpStatus.CREATED);	
	}
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<CenovnikDTO> updateCenovnik(@RequestBody CenovnikDTO cDTO, @PathVariable("id") Integer id){
		Cenovnik cenovnik = cenovnikServis.findOne(id);
		if (cenovnik == null) {
			return new ResponseEntity<CenovnikDTO>(HttpStatus.BAD_REQUEST);
		}			
		cenovnik.setDatum_do(cDTO.getDatum_do());
		cenovnik.setDatum_od(cDTO.getDatum_od());
		cenovnik.setProcenat(cDTO.getProcenat());
		cenovnik.setUkupna_cena(cDTO.getUkupna_cena());
		 cenovnikServis.save(cenovnik);
		CenovnikDTO cenovnikDTO = new CenovnikDTO(cenovnik);
		return new ResponseEntity<CenovnikDTO>(cenovnikDTO, HttpStatus.OK);	
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteRule(@PathVariable("id") Integer id){
		Cenovnik cenovnik = cenovnikServis.findOne(id);
		if (cenovnik != null){
			cenovnikServis.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	

}
