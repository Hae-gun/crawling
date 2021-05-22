package com.example.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.BojService;
import com.example.service.JpaServices;
import com.example.vo.BojVo;
import com.example.vo.TestVo;

@RestController
@RequestMapping("/boj")
public class JsonController {
	

	private final JpaServices jpaServices;
	private final BojService bojService;
	public JsonController(JpaServices jpaServices,BojService bojService) {
		System.out.println("make JsonController");
		this.jpaServices = jpaServices;
		this.bojService = bojService;
	}
//	
	
	@GetMapping("/test")
	public List<TestVo> getAll(TestVo vo) {
		System.out.println(jpaServices.findAll());
		return jpaServices.findAll();
	}
	
	@PostMapping("/data")
	public TestVo addVo(TestVo testVo) {
		System.out.println(testVo);
		return jpaServices.insertOne(testVo);
	}
	@GetMapping("/probs/{tier}")
	public JSONObject testBoj(@PathVariable String tier) throws FileNotFoundException, IOException, ParseException {
		return bojService.getJsonData(tier);
	}
	@PostMapping("/probArrs/{tier}")
	public JSONObject saveJsonData(@PathVariable String tier) throws FileNotFoundException, IOException, ParseException {
		return bojService.saveTierData(tier);
	}
	@GetMapping("/probArrs/{tier}")
	public List<BojVo> searchTierData(@PathVariable String tier) throws FileNotFoundException, IOException, ParseException {
		return bojService.searchByTier(tier);
	}
	@GetMapping("/probArrs")
	public List<BojVo> searchAllData() throws FileNotFoundException, IOException, ParseException {
		return bojService.searchAll();
	}
	@GetMapping("/prob/{name}")
	public List<BojVo> searchByName(@PathVariable String name){
		return bojService.searchByName(name);
	}
	@GetMapping("/random/{tier}")
	public List<BojVo> getRandomProb(@PathVariable String tier){
		return bojService.randomProb(tier,0);
	}
	@GetMapping("/random/{tier}/{level}")
	public List<BojVo> getRandomProb(@PathVariable String tier,@PathVariable int level){
		return bojService.randomProb(tier,level);
	}
}
