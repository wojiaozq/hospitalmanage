package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.SolvePatient;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.SolvePatientService
 * @description:
 * @author:
 * @create: 2019-04-03 20:59:07
 **/
public interface SolvePatientService {

    public List<SolvePatient> findAllByProblem(String problemId);
    public void add(SolvePatient solvePatient);




}
