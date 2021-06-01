package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.vo.School;
@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
