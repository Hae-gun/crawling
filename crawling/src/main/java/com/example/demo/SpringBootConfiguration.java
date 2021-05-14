package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.python.util.PythonInterpreter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.service.PythonModule;
import com.example.vo.TestVo;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:/application.properties")
public class SpringBootConfiguration {
	
	@Bean
	public PythonInterpreter pythonInterpreter() {
		return new PythonInterpreter();
	}
	
	@Bean
	public TestVo testVo() {
		return new TestVo();
	}
	
	@Bean
	public PythonModule pythonModule() {
		return new PythonModule(pythonInterpreter());
	}
}
