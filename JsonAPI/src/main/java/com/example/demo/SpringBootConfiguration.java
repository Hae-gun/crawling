package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.vo.TestVo;


@Configuration
@ComponentScan(basePackages = "com.example") 
@PropertySource("classpath:/application.properties")
public class SpringBootConfiguration {
	 
	@Bean 
	public TestVo testVo() {
		return new TestVo();
	}
	
	
}
