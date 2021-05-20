package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vo.BojVo;
@Repository
public interface BojRepository extends JpaRepository<BojVo, Long>{

}
