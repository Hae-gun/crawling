package com.example.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.simple.JSONArray;
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

	public JSONObject readJsonFile(String tier) throws FileNotFoundException, IOException, ParseException {
		String selectTier = tier.toLowerCase();
		ClassPathResource resource = new ClassPathResource("python/tier_" + selectTier + ".json");
		Path path = Paths.get(resource.getURI());
		return (JSONObject) parser.parse(new FileReader(path.toString()));
	}

	public JSONObject getJsonData(String tier) throws FileNotFoundException, IOException, ParseException {

		JSONObject jobj = readJsonFile(tier);
		JSONObject prob = (JSONObject) jobj.get("list");
		return prob;
	}

	public JSONObject saveTierData(String tier) throws FileNotFoundException, IOException, ParseException {
		JSONObject data = getJsonData(tier);
		String[] levels = { "0", "1", "2", "3", "4" };
		JSONObject result = new JSONObject();
		for (String lv : levels) {
			JSONArray jarr = (JSONArray) data.get(lv);
			for (int i = 0; i < jarr.size(); i++) {
				JSONObject obj = (JSONObject) jarr.get(i);
				obj.put("level", tier + (5 - Integer.valueOf(lv)));
				BojVo vo = new BojVo(obj.get("id").toString(), obj.get("level").toString(), obj.get("name").toString(),
						obj.get("url").toString());
				repository.save(vo);
			}
		}
		makeResultMsg(result);
		return result;
	}

	public List<BojVo> searchByTier(String tier) {
		String search = "%" + tier.toLowerCase() + "%";
		return ((BojRepository) repository).findByLevelLike(search);
	}

	public List<BojVo> searchAll() {
		return repository.findAll();
	}
	
	private void makeResultMsg(JSONObject result) {
		result.put("code", "0000");
		result.put("action", "saveTierData");
		result.put("msg", "complete");
	}

	public List<BojVo> searchByName(String name) {
		String search = "%"+name.toLowerCase()+"%";
		return ((BojRepository) repository).findByNameLike(search);
	}

	

	public List<BojVo> randomProb(String tier, int i) {
		String level = i != 0 ? tier+i:tier;
		List allProb = searchByTier(level);
		return allProb;
	}
}
