package com.wenming.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wenming.springboot.entity.RolePermission;

@Mapper
@SuppressWarnings("rawtypes")
public interface RolePermissionDao {
	
	RolePermission get(int id);

	List<RolePermission> find(Map map);

	List<RolePermission> page(Map map);

	int total(Map map);

	boolean save(RolePermission rolePermission);

	boolean update(RolePermission rolePermission);

	int delete(int id);

	RolePermission findById(int id);

	List<RolePermission> findAll();
}
