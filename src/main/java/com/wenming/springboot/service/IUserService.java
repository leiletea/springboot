package com.wenming.springboot.service;

import java.util.List;
import java.util.Map;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.entity.User;

@SuppressWarnings("rawtypes")
public interface IUserService{
	
	User get(int id);

	List<User> find(Map map);

	Page page(Page page, Map map);

	boolean save(User user);

	boolean update(User user);

	int delete(int id);
	
	User getUserByUsername(String username);
}
