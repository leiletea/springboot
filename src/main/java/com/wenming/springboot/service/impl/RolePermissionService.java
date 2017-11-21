package com.wenming.springboot.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.constant.SystemConstant;
import com.wenming.springboot.dao.RolePermissionDao;
import com.wenming.springboot.entity.RolePermission;
import com.wenming.springboot.service.IRolePermissionService;

@Service
public class RolePermissionService implements IRolePermissionService {
	
	@Resource
	private RolePermissionDao rolePermissionDao;

	@Override
	public RolePermission get(int id) {
		return rolePermissionDao.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<RolePermission> find(Map map) {

		return rolePermissionDao.find(map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page page(Page page, Map map) {
		int total = rolePermissionDao.total(map);
		if (total == 0) {
			return page;
		}
		page.setTotal(total);
		map.put(SystemConstant.PAGE_START_INDEX, page.getStartIndex());
		map.put(SystemConstant.PAGE_SIZE, page.getPageSize());
		List<RolePermission> rows = rolePermissionDao.page(map);
		page.setRows(rows);
		return page;
	}

	@Override
	public boolean save(RolePermission rolePermission) {
		return rolePermissionDao.save(rolePermission);
	}

	@Transactional
	@Override
	public boolean update(RolePermission rolePermission) {
		return rolePermissionDao.update(rolePermission);
	}

	@Override
	public int delete(int id) {
		return rolePermissionDao.delete(id);
	}
}
