package com.example.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.TestVo;

@RestController
@RequestMapping("/test")
public class Test {
	
	private final TestVo testVo;
	
	public Test(TestVo testVo) {
		this.testVo = testVo;
	}
	
	@GetMapping("/json")
	public void json() throws IOException, ParseException {
		ClassPathResource cpr = new ClassPathResource("/json/result.json");
		byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
		String jsonTxt = new String(bdata,StandardCharsets.UTF_8);
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject) parser.parse(jsonTxt);
		List<TestVo> list = new ArrayList<>();
		for(Object key: jObj.keySet()) {
			list.add(new TestVo(key.toString(),jObj.get(key).toString()));
		}
		System.out.println(list);
	}
	
}
