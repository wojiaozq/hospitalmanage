package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Evlauate;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.EvlauateService
 * @description:
 * @author:
 * @create: 2019-03-26 14:16:46
 **/
public interface EvlauateService {

    public List<Evlauate> findByDoctorId(String doctorId);

    public void delete(String id);

    public void add(Evlauate evlauate);
    public int countEvlauateByDoctorId(String doctorId);
}
