package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.vo.User;
@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
