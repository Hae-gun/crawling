package com.example.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.JdbcAccountRepository;
import com.example.service.JdbcService;
import com.example.vo.Account;
import com.example.vo.TestVo;

@RestController
@RequestMapping("/test")
public class Test {
	
	private final JdbcService jdbcService; 
	
	public Test(JdbcService jdbcService) {
		this.jdbcService = jdbcService;
	}
	
//	@GetMapping("/json")
//	public void json() throws IOException, ParseException {
//		ClassPathResource cpr = new ClassPathResource("/json/result.json");
//		byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
//		String jsonTxt = new String(bdata,StandardCharsets.UTF_8);
//		JSONParser parser = new JSONParser();
//		JSONObject jObj = (JSONObject) parser.parse(jsonTxt);
//		List<TestVo> list = new ArrayList<>();
//		for(Object key: jObj.keySet()) {
//			list.add(new TestVo(key.toString(),jObj.get(key).toString()));
//		}
//		System.out.println(list);
//	}
	
	@GetMapping("/accounts")
	public List<Account> getAll(){
		System.out.println("get All Account");
		return jdbcService.getAllEmail();
	}
	
	@GetMapping("/account/{id}")
	public Account findById(@PathVariable Long id){
		System.out.println("find ID:"+ id + " value");
		return jdbcService.findById(id);
	}
	
	@PostMapping("/enroll")
	public Long saveMember(Account account) {
		System.out.println("Enroll "+account);
		return jdbcService.saveMember(account);
	}
	
	@GetMapping("/delete/{id}")
	public int deleteById(@PathVariable Long id) {
		System.out.println("delete "+id+" value");
		return jdbcService.deleteById(id);
	}
	
	@GetMapping("/emails")
	public List<String> getAllEmails(){
		System.out.println("Enter get Emails");
		return jdbcService.getEmailsOnlyId();
	}
}
