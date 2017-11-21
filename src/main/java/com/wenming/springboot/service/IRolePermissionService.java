package com.wenming.springboot.service;

import java.util.List;
import java.util.Map;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.entity.RolePermission;

@SuppressWarnings("rawtypes")
public interface IRolePermissionService{
	
	RolePermission get(int id);

	List<RolePermission> find(Map map);

	Page page(Page page, Map map);

	boolean save(RolePermission rolePermission);

	boolean update(RolePermission rolePermission);

	int delete(int id);
}
