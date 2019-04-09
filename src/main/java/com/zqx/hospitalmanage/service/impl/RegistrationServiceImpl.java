package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.RegistrationDao;
import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.service.RegistrationService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.CORBA.Util;
import java.util.Date;
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

    @Override
    public void addRegistration(Registration registration) {
        this.registrationDao.save(registration);
    }

    @Override
    public List<Registration> findallRegis() {
        return this.registrationDao.findAll();
    }

    @Override
    public List<Registration> findByDoctorId(String doctorId, Date date) {
        return this.registrationDao.findByDoctorId(doctorId,date);
    }

    @Override
    public String fincount(String doctorid) {
        return this.registrationDao.findcountbyid(doctorid);
    }

}
