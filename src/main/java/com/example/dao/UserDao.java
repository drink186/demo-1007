package com.example.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserDao extends JpaRepository<User, Serializable>{
	public User findByAccount(String account);
}
