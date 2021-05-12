package com.example.demo;

import org.python.util.PythonInterpreter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.vo.TestVo;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SpringBootConfiguration {
	
	@Bean
	public PythonInterpreter pythonInterpreter() {
		return new PythonInterpreter();
	}
	
	@Bean
	public TestVo testVo() {
		return new TestVo();
	}
}
