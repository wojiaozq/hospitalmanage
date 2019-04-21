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
    public void add(Evlauate evlauate) {
        evlauate.setId(Utils.getUUID());
        this.evlauateDao.save(evlauate);
    }

    @Override
    public List<Evlauate> findallnull(String pid) {
        return this.evlauateDao.findallnull(pid);
    }

    @Override
    public Evlauate findbyid(String id) {
        return this.evlauateDao.findById(id).get();
    }

    @Override
    public void update(Evlauate evlauate) {
        evlauateDao.save(evlauate);
    }

    @Override
    public List<Evlauate> findallbyid(String doctorid) {
        return this.evlauateDao.findallbyid(doctorid);
    }

    @Override
    public int findcount(String doctorid) {
        return this.evlauateDao.findcountbyid(doctorid);
    }

    @Override
    public List<Evlauate> finbypid(String pid) {
       return this.evlauateDao.findallbypatientid(pid);
    }

    @Override
    public void delbypid(String pid) {
        this.evlauateDao.delBypidev(pid);
    }
}
