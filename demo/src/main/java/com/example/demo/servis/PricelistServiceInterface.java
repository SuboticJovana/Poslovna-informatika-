package com.example.demo.servis;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import com.example.demo.model.Pricelist;

public interface PricelistServiceInterface {
	
	Pricelist findByDateFrom (Date dateFrom);

	Pricelist findOne(Integer pricelist_id);
	
	List<Pricelist> findAll();
	
	Pricelist save(Pricelist pricelist);
	
	void remove(Integer pricelist_id);
	
//	Pricelist findByTotalPrice(Integer total_price);
	
	Page<Pricelist> findAll(int pageNo, int pageSize);
	
	Page<Pricelist> findAllByDateFrom(Date dateFrom, int pageNo, int pageSize);
}
