package com.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.StudentService;
import com.jpa.vo.ClassVo;
import com.jpa.vo.Student;
import com.jpa.vo.StudentDto;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private final StudentService stdService;
	
	public TestController(StudentService stdService) {
		this.stdService = stdService;
	}

	@GetMapping("/students")
	public List<StudentDto> allStudents() {
		return stdService.findAll();
	}
	
	
	@PostMapping("/student")
	public StudentDto register(Student stdVo, ClassVo clsVo) {
		return stdService.register(stdVo, clsVo);
	}
	
	
}
