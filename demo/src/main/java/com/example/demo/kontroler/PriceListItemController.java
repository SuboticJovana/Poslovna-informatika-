package com.example.demo.kontroler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CityDTO;
import com.example.demo.dto.InvoiceItemDTO;
import com.example.demo.dto.PriceListItemDTO;
import com.example.demo.model.City;
import com.example.demo.model.InvoiceItem;
import com.example.demo.model.PriceListItem;
import com.example.demo.servis.PriceListItemServiceInterface;

@RestController
@RequestMapping(value="salesystem/priceListItems")
public class PriceListItemController {
	
	@Autowired
	private PriceListItemServiceInterface priceListItemServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<PriceListItemDTO>> getItems(){
		List<PriceListItem> items = priceListItemServiceInterface.findAll();
		List<PriceListItemDTO> itemsDTO = new ArrayList<PriceListItemDTO>();
		for (PriceListItem pi : items) {
			itemsDTO.add(new PriceListItemDTO(pi));
		}
		return new ResponseEntity<List<PriceListItemDTO>>(itemsDTO, HttpStatus.OK);
	}

	@GetMapping(value="/{price_list_item_id}")
	public ResponseEntity<PriceListItemDTO> getItem(@PathVariable("price_list_item_id") Integer price_list_item_id){
		PriceListItem item = priceListItemServiceInterface.findOne(price_list_item_id);
		if(item == null) {
			return new ResponseEntity<PriceListItemDTO>(HttpStatus.NOT_FOUND);
		}
		PriceListItemDTO itemDTO = new PriceListItemDTO(item);
		return new ResponseEntity<PriceListItemDTO>(itemDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<PriceListItemDTO> saveItem(@RequestBody PriceListItemDTO piDTO){
		PriceListItem item = new PriceListItem();
		item.setPrice_list_item_id(piDTO.getPrice_list_item_id());
		item.setPrice(piDTO.getPrice());
		priceListItemServiceInterface.save(item);
		return new ResponseEntity<PriceListItemDTO>(piDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{price_list_item_id}", consumes="application/json")
	public ResponseEntity<PriceListItemDTO> updateItem(@RequestBody PriceListItemDTO piDTO, @PathVariable("price_list_item_id") Integer price_list_item_id){
		PriceListItem item = priceListItemServiceInterface.findOne(price_list_item_id);
		if (item == null) {
			return new ResponseEntity<PriceListItemDTO>(HttpStatus.BAD_REQUEST);
		}				
		item.setPrice_list_item_id(piDTO.getPrice_list_item_id());
		item.setPrice(piDTO.getPrice());
		priceListItemServiceInterface.save(item);
		PriceListItemDTO itemDTO = new PriceListItemDTO(item);
		return new ResponseEntity<PriceListItemDTO>(itemDTO, HttpStatus.OK);	
	}
	
	@DeleteMapping(value="/{price_list_item_id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("price_list_item_id") Integer price_list_item_id){
		PriceListItem item = priceListItemServiceInterface.findOne(price_list_item_id);
		if (item != null){
			priceListItemServiceInterface.remove(price_list_item_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
