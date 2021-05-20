package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.repository.TestRepository;
import com.example.vo.TestVo;

@Service
public class JpaServices {
	
	private final TestRepository testRepository;
	public JpaServices(TestRepository testRepository) {
		this.testRepository = testRepository;
	}
	public List<TestVo> findAll() {
		return testRepository.findAll();
	}
}
