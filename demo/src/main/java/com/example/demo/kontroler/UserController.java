package com.example.demo.kontroler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.servis.UserServiceInterface;

@RestController
@RequestMapping(value="salesystem/users")
public class UserController {

	@Autowired
	private UserServiceInterface service;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<Boolean> login(@RequestBody UserDTO userDTO){
		User u = service.findByUsernameAndPassword(userDTO.getUsername(),  userDTO.getPassword());
		if (u==null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK); 
		}else {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}
}
