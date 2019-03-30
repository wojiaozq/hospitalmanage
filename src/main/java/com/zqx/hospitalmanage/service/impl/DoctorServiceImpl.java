package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.AdministrativeDao;
import com.zqx.hospitalmanage.dao.DoctorDao;
import com.zqx.hospitalmanage.dao.DoctorRoleDao;
import com.zqx.hospitalmanage.dao.RoleDao;
import com.zqx.hospitalmanage.pojo.*;
import com.zqx.hospitalmanage.service.DoctorService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;

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
	@Autowired
	private AdministrativeDao administrativeDao;

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
		List<Doctor> all = doctorDao.findAll();
        Iterator<Doctor> it = all.iterator();
        while (it.hasNext()){
            Doctor next = it.next();
            if(next.getName().equals("root")){
                it.remove();
            }
        }
		Collections.reverse(all);
		return all;
	}

	public List<Doctor> findByStartAndEnd(String start, String end){
		if(Utils.stringIsNull(start) && Utils.stringIsNull(end)){
			return findAll();
		}
		try {
			if(!Utils.stringIsNull(start) && !Utils.stringIsNull(end)){
				return doctorDao.findByStartAndEnd(Utils.stringParseDate(start),Utils.stringParseDate(end));
			}
			return doctorDao.findByStart(Utils.stringParseDate(start==null?end:start));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Doctor> findByNameAndStartAndEnd(String name, String start, String end) {
		if(Utils.stringIsNull(name)){
			return findByStartAndEnd(start,end);
		}else{
			if(Utils.stringIsNull(start) && Utils.stringIsNull(end)){
				return doctorDao.findLikeName('%'+name+'%');
			}
			Date startDate;
			if(Utils.stringIsNull(start) || Utils.stringIsNull(end)){
				try {
					startDate = Utils.stringParseDate(Utils.stringIsNull(start)?end:start);
					return doctorDao.findLikeNameAndStart('%'+name+'%',startDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			List<Doctor> list = null;
			try {
				startDate = Utils.stringParseDate(start);
				Date endDate = Utils.stringParseDate(end);
				list = doctorDao.findLikeNameAndStartAndEnd('%'+name+'%',startDate,endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return list;
		}
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
		String administrativeName = administrativeDao.findById(doctor.getAdministrativeId()).get().getName();
		doctor.setAdministrativeName(administrativeName);
		doctorDao.save(doctor);
		doctorRoleDao.save(d);//分配医生角色
	}
	@Transactional
	public void update(Doctor doctor) {
        String administrativeId = doctor.getAdministrativeId();
        Administrative administrative = administrativeDao.findById(administrativeId).get();
        doctor.setAdministrativeName(administrative.getName());

		Role role = roleDao.findByName("医生");

		DoctorRole dr = new DoctorRole();
        dr.setId(Utils.getUUID());
        dr.setDoctorId(doctor.getId());
        dr.setRoleId(role.getId());

        doctorRoleDao.save(dr);

        doctor.setStatus("在职");
        doctorDao.save(doctor);
	}
	@Transactional
	public void delete(String id) {
		doctorDao.deleteById(id);
	}

	@Override
	@Transactional
	public void updatePassword(String nowPassword, String id) {
		doctorDao.updatePassword(nowPassword,id);
	}

	@Override
	@Transactional
	public void updateStatus(String id) {
        String status = doctorDao.findById(id).get().getStatus();
        if(status == null ||status.equals("") || status.equals("离职")){
            doctorDao.updateStatus("在职",id);
        }else {
            doctorDao.updateStatus("离职",id);
        }
	}
    @Override
    @Transactional
    public void updateStatus2(String id) {
        doctorDao.updateStatus("在职",id);
    }

}
