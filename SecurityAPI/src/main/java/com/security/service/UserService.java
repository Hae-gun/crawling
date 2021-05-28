package com.security.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.security.vo.User;

@Service
public class UserService {
	
	private final JpaRepository repository;

	public UserService(JpaRepository repository) {
		this.repository = repository;
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	
}
