package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Role;

import java.util.List;


public interface RoleService {

	public List<Role> findAll();
	public void update(Role role);

	public void delete(String id) ;

	public void deleteList(String[] ids) ;

}
