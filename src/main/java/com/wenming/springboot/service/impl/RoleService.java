package com.wenming.springboot.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.constant.SystemConstant;
import com.wenming.springboot.dao.RoleDao;
import com.wenming.springboot.entity.Role;
import com.wenming.springboot.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Resource
	private RoleDao roleDao;

	@Override
	public Role get(int id) {
		return roleDao.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Role> find(Map map) {

		return roleDao.find(map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page page(Page page, Map map) {
		int total = roleDao.total(map);
		if (total == 0) {
			return page;
		}
		page.setTotal(total);
		map.put(SystemConstant.PAGE_START_INDEX, page.getStartIndex());
		map.put(SystemConstant.PAGE_SIZE, page.getPageSize());
		List<Role> rows = roleDao.page(map);
		page.setRows(rows);
		return page;
	}

	@Override
	public boolean save(Role role) {
		return roleDao.save(role);
	}

	@Transactional
	@Override
	public boolean update(Role role) {
		return roleDao.update(role);
	}

	@Override
	public int delete(int id) {
		return roleDao.delete(id);
	}
}
