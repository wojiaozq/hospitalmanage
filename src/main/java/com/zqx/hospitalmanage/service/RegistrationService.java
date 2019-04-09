package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.RegistrationService
 * @description:
 * @author:
 * @create: 2019-03-24 13:23:19
 **/
public interface RegistrationService {

    /*
    public List<Registration> getByPatientName(String PatientName) ;
    public void overRegistration(String id);*/

    public void addRegistration(Registration registration);
    public List<Registration>findallRegis();
    public List<Registration> findByDoctorId(String doctorId, Date date) ;
    public String fincount(String doctorid);



}
