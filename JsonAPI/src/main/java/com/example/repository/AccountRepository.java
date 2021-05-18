package com.example.repository;

import java.util.List;

import com.example.vo.Account;

public interface AccountRepository {
	int count();

	long save(Account account);

	int update(Account account);

	int deleteById(Long id);

	void deleteAll();

	List<Account> findAll();

	Account findById(Long id);

	Account findByEmail(String email);
}
