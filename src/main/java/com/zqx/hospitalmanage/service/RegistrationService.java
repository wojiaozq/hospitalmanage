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


    public void addRegistration(Registration registration);
    public List<Registration>findallRegis();
    public List<Registration> findByDoctorId(String doctorId) ;
    public List<Registration>findabypid(String patientId);
    public int finddoctorallcount(String doctorid);
    public int finddoctorlastcount(String doctorid,Date date);
    public int seltimecount(String doctorid,Date date);
    public void delrebypid(String pid);
    public void updregis(String id);
    public Registration selbydateandpid(String pid,String timedetails);
}
