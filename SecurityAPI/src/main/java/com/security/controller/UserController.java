package com.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.service.UserService;
import com.security.vo.User;

@RestController
@RequestMapping("/app")
public class UserController {
	
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return service.getUsers();
	}
	
}
