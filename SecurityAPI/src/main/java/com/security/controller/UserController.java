package com.security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.security.service.UserService;

@RestController
public class UserController {
	
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	
	
}
