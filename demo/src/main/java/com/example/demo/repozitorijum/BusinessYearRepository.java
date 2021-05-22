package com.example.demo.repozitorijum;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.BussinesYearDTO;
import com.example.demo.model.BusinessYear;

public interface BusinessYearRepository extends JpaRepository<BusinessYear, Integer> {
	
	@Query(value = "SELECT b FROM BusinessYear b where :currentDate BETWEEN b.dateFrom and b.dateTo")
	BusinessYear getYear(@Param("currentDate")Date currentDate);
	
	//

}
