package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.DoctorDao;
import com.zqx.hospitalmanage.dao.DoctorRoleDao;
import com.zqx.hospitalmanage.dao.RoleDao;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.DoctorRole;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.service.DoctorService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务层
 * 
 * @author Administrator
 */
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private Page<Doctor> page;
	@Autowired
	private DoctorRoleDao doctorRoleDao;
	@Autowired
	private RoleDao roleDao;

	//登录验证
	public Doctor login(String username,String password){
		return doctorDao.findByUsernameAndPassword(username,password);
	}

	//检查username是否可用
	public boolean checkUsername(String username) {
		if(doctorDao.findByUsername(username)!=null){
			return false;//用户名不可用
		}else{
			return true;//用户名可用
		}
	}

	@Override
	//根据username查询，username用于登录,username是唯一的
	public List<Doctor> getDoctorByUsername(String username) {
		return doctorDao.findLikeUsername('%'+username+'%');
	}

	@Override
	//根据医生姓名查找，姓名不是唯一的
	public List<Doctor> getDoctorByName(String name) {
		return doctorDao.findByName('%'+name+'%');
	}

	@Override
	public Page<Doctor> findAllByPage(int now, int size) {
		page.setSize(size);//每一页的数量
		page.setNum((int) doctorDao.count());//总数量
		page.setData(doctorDao.findAllByPage((now-1)*size,size*now));
		page.setNow(now);//当前页
		page.setTotal(Utils.pageTotal(page.getNum(),size));//总页数,params[总数量，没有数量]
		page.setLast(page.getTotal());
		return page;
	}

	public List<Doctor> findAll() {
		return doctorDao.findAll();
	}


	public Doctor findOneById(String id) {
		return doctorDao.findById(id).get();
	}

	@Transactional
	public void add(Doctor doctor) {
		doctor.setId(Utils.getUUID());
		DoctorRole d = new DoctorRole();
		d.setId(Utils.getUUID());
		d.setDoctorId(doctor.getId());
		d.setRoleId(roleDao.findByName("医生").getId());
		if(doctor.getPassword()==null || doctor.getPassword().equals("")){
			doctor.setPassword("123456");//为医生设置默认密码123456
		}
		doctor.setStatus("在职");
		doctorDao.save(doctor);
		doctorRoleDao.save(d);//分配医生角色
	}
	@Transactional
	public void update(Doctor doctor) {
		doctorDao.save(doctor);
	}
	@Transactional
	public void delete(String id) {
		doctorDao.deleteById(id);
	}

}
