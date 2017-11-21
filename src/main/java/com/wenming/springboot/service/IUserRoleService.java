package com.wenming.springboot.service;

import java.util.List;
import java.util.Map;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.entity.UserRole;

@SuppressWarnings("rawtypes")
public interface IUserRoleService{
	
	UserRole get(int id);

	List<UserRole> find(Map map);

	Page page(Page page, Map map);

	boolean save(UserRole userRole);

	boolean update(UserRole userRole);

	int delete(int id);
}
