package com.wenming.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.constant.SystemConstant;
import com.wenming.springboot.dao.UserDao;
import com.wenming.springboot.entity.User;
import com.wenming.springboot.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private UserDao userDao;

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<User> find(Map map) {

		return userDao.find(map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page page(Page page, Map map) {
		int total = userDao.total(map);
		if (total == 0) {
			return page;
		}
		page.setTotal(total);
		map.put(SystemConstant.PAGE_START_INDEX, page.getStartIndex());
		map.put(SystemConstant.PAGE_SIZE, page.getPageSize());
		List<User> rows = userDao.page(map);
		page.setRows(rows);
		return page;
	}

	@Override
	public boolean save(User user) {
		return userDao.save(user);
	}

	@Transactional
	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public int delete(int id) {
		return userDao.delete(id);
	}

	@Override
	public User getUserByUsername(String username) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nickname", username);
		List<User> users = find(map);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
