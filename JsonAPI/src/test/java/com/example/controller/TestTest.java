package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.repository.TestRepository;
import com.example.vo.TestVo;

@RunWith(SpringRunner.class)
class TestTest {
	@Autowired
	private TestRepository testRepository;
	
	@Test
	void test() {
		System.out.println(testRepository);
		testRepository.save(new TestVo("_name","_url"));
		assertEquals(testRepository.findById(0).get().getName(),"_name");
	}
	@Test
	void test2() {
		assertEquals(1, 1);
	}

}
