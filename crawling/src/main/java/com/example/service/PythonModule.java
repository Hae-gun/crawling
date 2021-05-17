package com.example.service;

import org.python.util.PythonInterpreter;
import org.springframework.core.io.ClassPathResource;

public class PythonModule {
	
	private final PythonInterpreter intPre;
	int count = 0;
	public PythonModule(PythonInterpreter intPre) {
		this.intPre = intPre;
	}
	public void getCrawlingData(String url) {
		System.out.println("COUNT UP" + count++);
	}
}
