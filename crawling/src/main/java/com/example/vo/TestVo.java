package com.example.vo;

public class TestVo {
	private String name;
	private String code;
	
	public TestVo() {
		
	}
	
	public TestVo(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "TestVo [name=" + name + ", code=" + code + "]";
	}
	
	
}
