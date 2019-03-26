package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.RegistrationDao;
import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.service.RegistrationService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.RegistrationServiceImpl
 * @description:
 * @author:
 * @create: 2019-03-24 13:23:30
 **/
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;

    @Override//查询某一医生下的所有挂号信息
    public List<Registration> getByDoctorId(String doctorId) {
        return registrationDao.findByDoctorId(doctorId);
    }

    @Override//查询某一患者的所有挂号信息
    public List<Registration> getByPatientName(String PatientName) {
        return registrationDao.findByPatientName('%'+PatientName+'%');
    }

    //完成挂号，状态该为0
    @Transactional
    public void overRegistration(String id){
        registrationDao.updateStatus(0,id);
    }

    //病人挂号
    @Transactional
    public void addRegistration(Registration registration){
        registration.setStatus(1);//状态设置为1，表示为开始
        registration.setId(Utils.getUUID());//设置主键
    }


}
