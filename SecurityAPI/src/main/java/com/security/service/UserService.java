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

	public List<User> getUsers() {
		return repository.findAll();
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

}
