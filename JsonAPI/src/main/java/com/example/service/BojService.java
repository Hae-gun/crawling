package com.example.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.repository.BojRepository;
import com.example.vo.BojVo;

@Service
public class BojService {
	
	JSONParser parser = new JSONParser();
	
	private final JpaRepository repository;
	public BojService(BojRepository repository) {
		this.repository = repository;
	}
	
	public List<List<BojVo>> getJsonData() throws FileNotFoundException, IOException, ParseException{
		ClassPathResource resource = new ClassPathResource("json/result.json");
		Path path = Paths.get(resource.getURI());
		Object obj = parser.parse(new FileReader(path.toString()));
		JSONObject jobj = (JSONObject)obj;
		System.out.println(jobj);
		return null;
	}
}
