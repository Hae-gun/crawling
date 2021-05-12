package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.python.util.JythoncAntTask;
import org.python.util.PythonInterpreter;
import org.python.util.jython;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.TestVo;

@RestController
public class MainController {
	
	private final PythonInterpreter intPre;
	private final TestVo testVo;
	public MainController(PythonInterpreter intPre,TestVo testVo) {
		this.intPre=intPre;
		this.testVo=testVo;
	}
	@GetMapping("/test")
	public Map<String, String> test() {
		Map map = new HashMap<String,String>();
		
		return map;
	}
	
	@GetMapping("/testVo/{code}")
	public TestVo getTestVo(@PathVariable String code) {
		this.testVo.setCode(code);
		this.testVo.setName("My Name is");
		return this.testVo;
	}
}
