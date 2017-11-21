package com.wenming.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wenming.springboot.entity.Role;

@Mapper
@SuppressWarnings("rawtypes")
public interface RoleDao {
	
	Role get(int id);

	List<Role> find(Map map);

	List<Role> page(Map map);

	int total(Map map);

	boolean save(Role role);

	boolean update(Role role);

	int delete(int id);

	Role findById(int id);

	List<Role> findAll();
}
