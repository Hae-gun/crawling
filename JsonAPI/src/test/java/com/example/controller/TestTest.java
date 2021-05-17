package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.repository.TestRepository;
import com.example.vo.TestVo;

class TestTest {

	private final TestRepository repository;
	public TestTest(TestRepository repository) {
		this.repository = repository;
	}
	
	@Test
	void test() {
		repository.save(new TestVo("_name","_url"));
		assertEquals(repository.findById(0).get().getName(),"_name");
	}
	@Test
	void test2() {
		assertEquals(1, 1);
	}

}
