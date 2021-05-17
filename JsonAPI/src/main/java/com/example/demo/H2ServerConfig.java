package com.example.demo;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repository.TestRepository;
import com.example.repository.TestRepositoryImpl;

@Configuration
public class H2ServerConfig {
	@Bean
	public Server h2Tcpserver() throws SQLException {
		return Server.createTcpServer().start();
	}
	@Bean
	public TestRepository testRepository() throws SQLException {
		return new TestRepositoryImpl(h2Tcpserver());
	}
}
