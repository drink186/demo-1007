package com.example.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Permission;

public interface PermissionDao extends JpaRepository<Permission, Serializable>{

}
