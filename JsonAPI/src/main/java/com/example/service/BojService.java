package com.example.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.repository.BojRepository;

@Service
public class BojService {
	
	JSONParser parser = new JSONParser();
	
	private final JpaRepository repository;
	public BojService(BojRepository repository) {
		this.repository = repository;
	}
	
	public JSONObject readJsonFile(String tier) throws FileNotFoundException, IOException, ParseException {
		String selectTier = tier.toLowerCase();
		ClassPathResource resource = new ClassPathResource("python/tier_"+selectTier+".json");
		Path path = Paths.get(resource.getURI());
		return (JSONObject)parser.parse(new FileReader(path.toString()));
	}
	
	
	public JSONObject getJsonData(String tier) throws FileNotFoundException, IOException, ParseException{
		
		JSONObject jobj = readJsonFile(tier);
		JSONObject prob = (JSONObject) jobj.get("list");
		return prob;
	}
	public JSONObject saveTierData(String tier) throws FileNotFoundException, IOException, ParseException {
		JSONObject data = getJsonData(tier);
		String[] levels = {"0","1","2","3","4"};
		for(String lv:levels) {
			JSONArray jarr = (JSONArray)data.get(lv);
			System.out.println(lv+" __ " + jarr);
		}
		return data;
	}
	
}
