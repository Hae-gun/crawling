package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.vo.StudentClass;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Long>{

}
