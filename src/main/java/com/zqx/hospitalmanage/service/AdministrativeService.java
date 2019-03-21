package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Administrative;

import java.util.List;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
public interface AdministrativeService {

	public List<Administrative> findAll() ;


	public Administrative findOne(String id) ;

	public void update(Administrative administrative);
	public void save(Administrative administrative);

	public void delete(String id) ;

	public void deleteList(String[] ids) ;

}
