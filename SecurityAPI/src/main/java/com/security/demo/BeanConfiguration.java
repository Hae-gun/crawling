package com.security.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.security.dao")
@EntityScan(basePackages = "com.security.vo")
public class BeanConfiguration {
	
}
