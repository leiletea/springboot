package com.wenming.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wenming.springboot.entity.Permission;


@Mapper
@SuppressWarnings("rawtypes")
public interface PermissionDao {
	
	Permission get(int id);

	List<Permission> find(Map map);

	List<Permission> page(Map map);

	int total(Map map);

	boolean save(Permission permission);

	boolean update(Permission permission);

	int delete(int id);

	Permission findById(int id);

	List<Permission> findAll();
}
