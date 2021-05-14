package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.PythonModule;
import com.example.vo.TestVo;

@RestController
public class PythonController {
	
	@Autowired
	ApplicationContext context;
	
	private final TestVo testVo;
	private final PythonModule pyModule;
	
	public PythonController(PythonInterpreter intPre,TestVo testVo,PythonModule pyModule) {
		this.testVo=testVo;
		this.pyModule = pyModule;
	}
	
	@GetMapping("/test")
	public Map<String, String> test() {
		Environment enviroment = context.getEnvironment();
		Map<String,String> map = new HashMap<String,String>();
		map.put("key", enviroment.getProperty("test.testNumber"));
		pyModule.getCrawlingData(map.get("key"));
		return map;
	}
	
	@GetMapping("/testVo/{code}")
	public TestVo getTestVo(@PathVariable String code) {
		this.testVo.setCode(code);
		this.testVo.setName("My Name is");
		pyModule.getCrawlingData(code);
		return this.testVo;
	}
	
}
