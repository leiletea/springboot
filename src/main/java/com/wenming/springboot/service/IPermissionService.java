package com.wenming.springboot.service;

import java.util.List;
import java.util.Map;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.entity.Permission;

@SuppressWarnings("rawtypes")
public interface IPermissionService{
	
	Permission get(int id);

	List<Permission> find(Map map);

	Page page(Page page, Map map);

	boolean save(Permission permission);

	boolean update(Permission permission);

	int delete(int id);
}
