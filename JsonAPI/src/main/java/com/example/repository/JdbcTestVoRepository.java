package com.example.repository;

import java.util.List;

import com.example.vo.Account;

public class JdbcTestVoRepository implements JdbcRepository {

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> long save(T account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> int update(T account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
