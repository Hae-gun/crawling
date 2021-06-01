package com.jpa.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpa.repository.StudentRepository;
import com.jpa.service.StudentService;

@Configuration
@ComponentScan(basePackages = "com.jpa")
//@EnableJpaRepositories(basePackages = "com.jpa.repository")
public class ServiceConfig {
	
	@Autowired
	public StudentRepository repository;
	
	@Bean
	public StudentService studentService() {
		return new StudentService(repository);
	}
}
