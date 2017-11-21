package com.wenming.springboot.service;

import java.util.List;
import java.util.Map;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.entity.Role;

@SuppressWarnings("rawtypes")
public interface IRoleService{
	
	Role get(int id);

	List<Role> find(Map map);

	Page page(Page page, Map map);

	boolean save(Role role);

	boolean update(Role role);

	int delete(int id);
}
