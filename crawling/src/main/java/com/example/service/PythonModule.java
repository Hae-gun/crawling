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
		ClassPathResource resource = new ClassPathResource("python/crawlingScript.py");
		System.out.println(resource.getPath());
		intPre.execfile(resource.getPath());
		intPre.exec("crawling('"+url+"')");
		System.out.println("COUNT UP" + count++);
//		return 
	}
}
