package com.wenming.springboot.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenming.springboot.constant.Page;
import com.wenming.springboot.constant.SystemConstant;
import com.wenming.springboot.dao.PermissionDao;
import com.wenming.springboot.entity.Permission;
import com.wenming.springboot.service.IPermissionService;

@Service
public class PermissionService implements IPermissionService {
	
	@Resource
	private PermissionDao permissionDao;

	@Override
	public Permission get(int id) {
		return permissionDao.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Permission> find(Map map) {

		return permissionDao.find(map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page page(Page page, Map map) {
		int total = permissionDao.total(map);
		if (total == 0) {
			return page;
		}
		page.setTotal(total);
		map.put(SystemConstant.PAGE_START_INDEX, page.getStartIndex());
		map.put(SystemConstant.PAGE_SIZE, page.getPageSize());
		List<Permission> rows = permissionDao.page(map);
		page.setRows(rows);
		return page;
	}

	@Override
	public boolean save(Permission permission) {
		return permissionDao.save(permission);
	}

	@Transactional
	@Override
	public boolean update(Permission permission) {
		return permissionDao.update(permission);
	}

	@Override
	public int delete(int id) {
		return permissionDao.delete(id);
	}
}
