package com.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.repository.ClassVoRepository;
import com.jpa.repository.StudentClassRepository;
import com.jpa.repository.StudentRepository;
import com.jpa.vo.ClassVo;
import com.jpa.vo.Student;
import com.jpa.vo.StudentDto;

public class StudentService {
	
	private final StudentRepository stdRepo;
	private final StudentClassRepository stdClsRepo;
	private final ClassVoRepository clsRepo;


	public StudentService(StudentRepository stdRepo, StudentClassRepository stdClsRepo, ClassVoRepository clsRepo) {
		this.stdRepo = stdRepo;
		this.stdClsRepo = stdClsRepo;
		this.clsRepo = clsRepo;
	}

	public List<Student> getAll(Long id) {
		return stdRepo.findAll();
	}

	public List<Student> findById(Long id) {
		return stdRepo.findAll();
	}

	public List<StudentDto> findAll() {
		List<Student> tmp = stdRepo.findAll();
		List<StudentDto> studnets = new ArrayList<StudentDto>();
		for(Student std : tmp) {
			studnets.add(new StudentDto(std.getId(),std.getName(),std.getSchool().getName()));
		}
		return studnets;
	}

	public StudentDto register(Student stdVo, ClassVo clsVo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
