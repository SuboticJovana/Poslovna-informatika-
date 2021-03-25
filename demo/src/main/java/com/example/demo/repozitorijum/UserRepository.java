package com.example.demo.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String username, String password);
	
	//User findByEnterprise_Enterprise_id(Integer enterprise_id);
	
	User findByUsername(String username);
	
}
