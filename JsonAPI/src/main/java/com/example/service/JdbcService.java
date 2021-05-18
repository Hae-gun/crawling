package com.example.service;

import java.util.List;

import com.example.repository.JdbcAccountRepository;
import com.example.vo.Account;

public class JdbcService {
	
	private final JdbcAccountRepository jdbcAccountRepository; 
	public JdbcService(JdbcAccountRepository jdbcAccountRepository) {
		this.jdbcAccountRepository = jdbcAccountRepository;
	}
	public List<Account> getAllEmail() {
		return jdbcAccountRepository.findAll();
	}
	public Account findById(Long id) {
		return jdbcAccountRepository.findById(id);
	}

	
}
