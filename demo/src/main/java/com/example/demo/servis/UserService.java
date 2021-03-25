package com.example.demo.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repozitorijum.UserRepository;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User save(User u) {
		return repository.save(u);
	}

	@Override
	public void remove(Integer id) {
		 repository.deleteById(id);
	}

//	@Override
//	public User findByEnterprise_Enterprise_id(Integer enterprise_id) {
//		return repository.findByEnterprise_Enterprise_id(enterprise_id);
//	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	

}
