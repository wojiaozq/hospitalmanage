package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Problem;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ProblemService
 * @description:
 * @author:
 * @create: 2019-04-03 12:45:08
 **/
public interface ProblemService {

    void save(Problem p);
    public List<Problem> findByPatientId(String patientId);

    List<Problem> findAll();
    public Problem findOne(String id);

}
