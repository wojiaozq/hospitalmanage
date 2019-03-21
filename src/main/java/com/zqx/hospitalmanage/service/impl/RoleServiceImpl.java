package com.zqx.hospitalmanage.service.impl;

import java.util.List;

import com.zqx.hospitalmanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqx.hospitalmanage.dao.RoleDao;
import com.zqx.hospitalmanage.pojo.Role;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务层
 * @author Administrator
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Transactional
	public void update(Role role) {
		roleDao.save(role);
	}

	@Transactional
	public void delete(String id) {
		roleDao.deleteById(id);
	}

	@Transactional
	public void deleteList(String[] ids) {

	}

}
