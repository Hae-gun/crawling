package com.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.security.vo.User;

@Service
public class UserService {

	private final JpaRepository repository;

	public UserService(JpaRepository repository) {
		this.repository = repository;
	}

	public List<User> getUsers() {
		return Optional.ofNullable(repository.findAll()).get() ;
	}

	public void reset() {
		repository.deleteAll();
	}

	public boolean register(User user) {
		try {
			repository.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public User getUser(String id) {
		Optional<User> userResult = repository.findById(id);
		return userResult.get(); 
	}

}
