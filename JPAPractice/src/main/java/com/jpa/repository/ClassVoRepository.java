package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.vo.ClassVo;
@Repository
public interface ClassVoRepository extends JpaRepository<ClassVo, Long>{

}
