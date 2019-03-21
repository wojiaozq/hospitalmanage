package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.AdministrativeDao;
import com.zqx.hospitalmanage.pojo.Administrative;
import com.zqx.hospitalmanage.service.AdministrativeService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务层
 * @author Administrator
 */
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

	@Autowired
	private AdministrativeDao administrativeDao;

	public List<Administrative> findAll() {
		return administrativeDao.findAll();
	}

	public Administrative findOne(String id) {
		return administrativeDao.findById(id).get();
	}
	@Transactional
	public void update(Administrative administrative) {
		administrativeDao.save(administrative);
	}

	@Override
	@Transactional
	public void save(Administrative administrative) {
		administrative.setId(Utils.getUUID());
		administrativeDao.save(administrative);
	}
	@Transactional
	public void delete(String id) {
		administrativeDao.deleteById(id);
	}
	@Transactional
	public void deleteList(String[] ids) {

	}

}
