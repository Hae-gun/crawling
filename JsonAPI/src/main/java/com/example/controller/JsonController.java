package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.JpaServices;
import com.example.vo.TestVo;

@RestController
@RequestMapping("/json")
public class JsonController {
	

	private final JpaServices jpaServices;
	public JsonController(JpaServices jpaServices) {
		System.out.println("make JsonController");
		this.jpaServices = jpaServices;
	}
//	
	
	@GetMapping("/test")
	public List<TestVo> getAll(TestVo vo) {
		System.out.println(jpaServices.findAll());
		return jpaServices.findAll();
	}
	
	@PostMapping("/data")
	public TestVo addVo(TestVo testVo) {
		System.out.println(testVo);
		return jpaServices.insertOne(testVo);
	}
//	@PostMapping("/datas")
}
