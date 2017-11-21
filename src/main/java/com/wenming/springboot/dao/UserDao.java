package com.wenming.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wenming.springboot.entity.User;

@Mapper
@SuppressWarnings("rawtypes")
public interface UserDao {
	
	User get(int id);

	List<User> find(Map map);

	List<User> page(Map map);

	int total(Map map);

	boolean save(User user);

	boolean update(User user);

	int delete(int id);

	User findById(int id);

	List<User> findAll();
}
