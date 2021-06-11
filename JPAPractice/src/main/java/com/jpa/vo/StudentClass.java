package com.jpa.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentClass {
	
	@Id
	private Long id;
	
	@ManyToOne
//	@JoinColumn(name="")
	private Student student;
	
	@ManyToOne
//	@JoinColumn(name="")
	private ClassVo classVo;

	public StudentClass() {
	}

	public StudentClass(Long id, Student student, ClassVo classVo) {
		this.id = id;
		this.student = student;
		this.classVo = classVo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ClassVo getClassVo() {
		return classVo;
	}

	public void setClassVo(ClassVo classVo) {
		this.classVo = classVo;
	}
	
	
	
}
