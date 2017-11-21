package com.wenming.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wenming.springboot.entity.UserRole;

@Mapper
@SuppressWarnings("rawtypes")
public interface UserRoleDao {
	
	UserRole get(int id);

	List<UserRole> find(Map map);

	List<UserRole> page(Map map);

	int total(Map map);

	boolean save(UserRole userRole);

	boolean update(UserRole userRole);

	int delete(int id);

	UserRole findById(int id);

	List<UserRole> findAll();
}
