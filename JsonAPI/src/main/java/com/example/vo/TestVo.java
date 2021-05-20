package com.example.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class TestVo {
	@Id
	private int id;
	private String name;
	private String url;
	
}
