package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BusinessYear;

public interface BusinessYearRepository extends JpaRepository<BusinessYear, Integer> {

}
