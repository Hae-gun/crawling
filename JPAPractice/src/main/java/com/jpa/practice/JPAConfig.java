package com.jpa.practice;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpa.vo.Auditor;
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Configuration
@EntityScan(basePackages = "com.jpa.vo")
@EnableJpaRepositories(basePackages = "com.jpa.repository")
public class JPAConfig {
	
	@Bean
    public AuditorAware<String> auditorProvider() {
        return new Auditor();
    }
}
