package com.jpa.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClassVo {
	@Id
	private Long id;
	
	private String className;
	private String time;
	
	@OneToMany(mappedBy = "classVo")
	private List<StudentClass> studentClasses = new ArrayList<StudentClass>();

	public ClassVo() {
	}

	public ClassVo(Long id, String className, String time, List<StudentClass> studentClasses) {
		this.id = id;
		this.className = className;
		this.time = time;
		this.studentClasses = studentClasses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<StudentClass> getStudentClasses() {
		return studentClasses;
	}

	public void setStudentClasses(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}
	
	
	
	
}
