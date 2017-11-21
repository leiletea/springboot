package com.wenming.springboot.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.constant.SystemConstant;
import com.wenming.springboot.dao.UserRoleDao;
import com.wenming.springboot.entity.UserRole;
import com.wenming.springboot.service.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService {
	
	@Resource
	private UserRoleDao userRoleDao;

	@Override
	public UserRole get(int id) {
		return userRoleDao.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<UserRole> find(Map map) {

		return userRoleDao.find(map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page page(Page page, Map map) {
		int total = userRoleDao.total(map);
		if (total == 0) {
			return page;
		}
		page.setTotal(total);
		map.put(SystemConstant.PAGE_START_INDEX, page.getStartIndex());
		map.put(SystemConstant.PAGE_SIZE, page.getPageSize());
		List<UserRole> rows = userRoleDao.page(map);
		page.setRows(rows);
		return page;
	}

	@Override
	public boolean save(UserRole userRole) {
		return userRoleDao.save(userRole);
	}

	@Transactional
	@Override
	public boolean update(UserRole userRole) {
		return userRoleDao.update(userRole);
	}

	@Override
	public int delete(int id) {
		return userRoleDao.delete(id);
	}
}
