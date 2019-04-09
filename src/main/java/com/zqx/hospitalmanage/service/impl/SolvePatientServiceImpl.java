package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.SolvePatientDao;
import com.zqx.hospitalmanage.pojo.SolvePatient;
import com.zqx.hospitalmanage.service.SolvePatientService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.SolvePatientServiceImpl
 * @description:
 * @author:
 * @create: 2019-04-03 20:59:25
 **/
@Service
public class SolvePatientServiceImpl implements SolvePatientService {

    @Autowired
    private SolvePatientDao solvePatientDao;

    @Override
    public List<SolvePatient> findAllByProblem(String problemId) {
        return solvePatientDao.findAllByProblemId(problemId);
    }
    @Transactional
    public void add(SolvePatient solvePatient){
        solvePatient.setId(Utils.getUUID());
        solvePatientDao.save(solvePatient);
    }

    @Transactional
    public void del(String id) {
        solvePatientDao.delebyotherid(id);
    }
}
