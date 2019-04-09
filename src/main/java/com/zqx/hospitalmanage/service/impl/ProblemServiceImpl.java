package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.ProblemDao;
import com.zqx.hospitalmanage.pojo.Problem;
import com.zqx.hospitalmanage.service.ProblemService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ProblemServiceImpl
 * @description:
 * @author:
 * @create: 2019-04-03 12:45:43
 **/
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemDao problemDao;

    @Override
    public void save(Problem p) {
        p.setId(Utils.getUUID());
        p.setTime(new Date());
        problemDao.save(p);
    }

    public List<Problem> findByPatientId(String patientId){
        return problemDao.findByQuizzerId(patientId);
    }

    @Override
    public List<Problem> findAll() {
        return problemDao.findAll();
    }
    public Problem findOne(String id){
        return problemDao.findById(id).get();
    }

    @Transactional
    public void delprobleambyid(String id) {
        this.problemDao.deleteById(id);
    }

}
