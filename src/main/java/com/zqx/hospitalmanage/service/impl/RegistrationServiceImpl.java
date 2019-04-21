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
    public List<Registration> findabypid(String patientId) {
        return this.registrationDao.findbypatientid(patientId);
    }

    @Override
    public int finddoctorallcount(String doctorid) {
        return this.registrationDao.findcountbyid(doctorid);
    }

    @Override
    public int finddoctorlastcount(String doctorid, Date date) {
        return this.registrationDao.findcountlast(doctorid,date);
    }

    @Override
    public int seltimecount(String doctorid, Date date) {
        return this.registrationDao.findcountdatecount(doctorid,date);
    }

    @Override
    public void delrebypid(String pid) {
        this.registrationDao.deletebupid(pid);
    }

    @Override
    public void updregis(String id) {
        this.registrationDao.updateregist(id);
    }

    @Override
    public Registration selbydateandpid(String pid, String timedetails) {
        return this.registrationDao.findpidanddate(pid,timedetails);
    }


}
