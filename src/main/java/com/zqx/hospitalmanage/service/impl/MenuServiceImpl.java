package com.zqx.hospitalmanage.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.zqx.hospitalmanage.dao.RoleDao;
import com.zqx.hospitalmanage.pojo.Role;
import com.zqx.hospitalmanage.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.zqx.hospitalmanage.dao.MenuDao;
import com.zqx.hospitalmanage.pojo.Menu;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	@Autowired
	private RoleDao roleDao;

	public List<Menu> findAll() {
		Sort sort = new Sort(Sort.Direction.ASC, "url");
//		Pageable page = PageRequest.of(1,100,sort);sort
		return menuDao.findAll(sort);
	}

	public Menu findById(String id) {
		return menuDao.findById(id).get();
	}
	//查询该角色下的菜单
	public List<Menu> findAll(String roleId){
		List<Menu> menu = roleDao.findById(roleId).get().getMenu();
		Collections.reverse(menu);
		return menu;
	}

	@Transactional
	public void update(Menu menu) {
		menuDao.save(menu);
	}
	@Transactional
	public void delete(String id) {
		menuDao.deleteById(id);
	}
	@Transactional
	public void deleteList(String[] ids) {

	}

}
