package com.example.demo.kontroler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PriceListItemDTO;
import com.example.demo.dto.ServicesDTO;
import com.example.demo.model.PriceListItem;
import com.example.demo.model.Services;
import com.example.demo.servis.PriceListItemServiceInterface;
import com.example.demo.servis.ServicesServiceInterface;

@RestController
@RequestMapping(value="salesystem/servicess")
public class ServicesController {
	
	@Autowired
	private ServicesServiceInterface serviceServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ServicesDTO>> getServices(){
		List<Services> services = serviceServiceInterface.findAll();
		List<ServicesDTO> servicesDTO = new ArrayList<ServicesDTO>();
		for(Services s : services) {
			servicesDTO.add(new ServicesDTO(s));
	}
		return new ResponseEntity<List<ServicesDTO>>(servicesDTO, HttpStatus.OK);

}

	@GetMapping(value="/{services_id}")
	public ResponseEntity<ServicesDTO> getService(@PathVariable("services_id") Integer services_id){
		Services services = serviceServiceInterface.findOne(services_id);
		if(services == null) {
			return new ResponseEntity<ServicesDTO>(HttpStatus.NOT_FOUND);
		}
	ServicesDTO servicesDTO = new ServicesDTO(services);
		return new ResponseEntity<ServicesDTO>(servicesDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<ServicesDTO> saveServices(@RequestBody ServicesDTO siDTO){
		Services services = new Services();
		services.setDescription(siDTO.getDescription());
		services.setGoods(siDTO.getGoods());
		services.setName(siDTO.getName());
		services.setService_id(siDTO.getServices_id());

		serviceServiceInterface.save(services);
		return new ResponseEntity<ServicesDTO>(siDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{services_id}", consumes="application/json")
	public ResponseEntity<ServicesDTO> updateService(@RequestBody ServicesDTO siDTO, @PathVariable("services_id") Integer services_id){
		Services services = serviceServiceInterface.findOne(services_id);
		if (services == null) {
			return new ResponseEntity<ServicesDTO>(HttpStatus.BAD_REQUEST);
		}
		services.setDescription(siDTO.getDescription());
		services.setGoods(siDTO.getGoods());
		services.setName(siDTO.getName());
		services.setService_id(siDTO.getServices_id());
		
		serviceServiceInterface.save(services);
		ServicesDTO serviceDTO = new ServicesDTO(services);
		return new ResponseEntity<ServicesDTO>(serviceDTO, HttpStatus.OK);	
	}
	
	@DeleteMapping(value="/{price_list_item_id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("services_id") Integer services_id){
		Services services = serviceServiceInterface.findOne(services_id);
		if (services != null){
			serviceServiceInterface.remove(services_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
