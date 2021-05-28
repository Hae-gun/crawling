package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.vo.User;

public interface UserRepository extends JpaRepository<User, String>{

}
