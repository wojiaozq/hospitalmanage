package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Menu;

import java.util.List;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
public interface MenuService {

	public List<Menu> findAll() ;

	public Menu findById(String id);

	public List<Menu> findAll(String roleId);

	public void update(Menu menu);

	public void delete(String id) ;
	public void deleteList(String[] ids) ;

}
