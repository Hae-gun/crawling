package com.security.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.security.service.UserService;

@Configuration
public class WebConfiguration {
	
	@Bean
	public WebConfiguration webConfiguration() {
		return new WebConfiguration();
	}
	
}
