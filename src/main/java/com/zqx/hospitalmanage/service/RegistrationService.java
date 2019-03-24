package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.RegistrationService
 * @description:
 * @author: wangshu
 * @create: 2019-03-24 13:23:19
 **/
public interface RegistrationService {

    public List<Registration> getByDoctorId(String doctorId) ;

    public List<Registration> getByPatientName(String PatientName) ;

    public void overRegistration(String id);

    public void addRegistration(Registration registration);



}
