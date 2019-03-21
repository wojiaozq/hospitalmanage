package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Page;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.DoctorServiceImpl
 * @description:
 * @author: wangshu
 * @create: 2019-03-19 13:17:55
 **/
public interface DoctorService {
    public Doctor login(String username, String password);
    public boolean checkUsername(String username);
    public List<Doctor> getDoctorByUsername(String username);

    public List<Doctor> getDoctorByName(String name);

    public Page<Doctor> findAllByPage(int now, int size);

    public List<Doctor> findAll() ;

    public Doctor findOneById(String id);

    public void add(Doctor doctor) ;

    public void update(Doctor doctor);

    public void delete(String id);
}