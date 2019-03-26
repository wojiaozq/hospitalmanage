package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.EvlauateDao;
import com.zqx.hospitalmanage.pojo.Evlauate;
import com.zqx.hospitalmanage.service.EvlauateService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.EvlauateServiceImpl
 * @description: 评价
 * @author:
 * @create: 2019-03-26 14:17:05
 **/
@Service
public class EvlauateServiceImpl implements EvlauateService {

    @Autowired
    private EvlauateDao evlauateDao;


    @Override
    public List<Evlauate> findByDoctorId(String doctorId) {
        return evlauateDao.findByDoctorId(doctorId);
    }

    @Override
    @Transactional
    public void delete(String id) {
        evlauateDao.deleteById(id);
    }

    @Override
    @Transactional
    public void add(Evlauate evlauate) {
        evlauate.setId(Utils.getUUID());
        evlauate.setTimer(new Date());
        System.out.println("操作失败!!!!!!!!!!!!!!!!!!!!!!!!!!!执行caseId插入操作!!!!!");

        if(true)return;//修改后注释该行
        evlauateDao.save(evlauate);
    }
    //评价统计数量
    public int countEvlauateByDoctorId(String doctorId){
        return evlauateDao.findByDoctorId(doctorId).size();
    }

}
