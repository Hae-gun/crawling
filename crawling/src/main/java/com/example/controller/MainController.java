package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.TestVo;

@RestController
public class MainController {
	
	@Autowired
	ApplicationContext context;
	
	private final PythonInterpreter intPre;
	private final TestVo testVo;
	public MainController(PythonInterpreter intPre,TestVo testVo) {
		this.intPre=intPre;
		this.testVo=testVo;
	}
	@GetMapping("/test")
	public Map<String, String> test() {
		Environment enviroment = context.getEnvironment();
		Map map = new HashMap<String,String>();
		map.put("key", enviroment.getProperty("test.testNumber"));
		intPre.cleanup();
		intPre.exec("import itertools.permutations");
		intPre.exec("permutations([1,2,3],2)");
		return map;
	}
	
	@GetMapping("/testVo/{code}")
	public TestVo getTestVo(@PathVariable String code) {
		this.testVo.setCode(code);
		this.testVo.setName("My Name is");
		return this.testVo;
	}
	
	public <K,V,T,Q,S> boolean methodName(K key, V value,T type,Q qulity, S specific) {
		
		return false;
	}
	
}
