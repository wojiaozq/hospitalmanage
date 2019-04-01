package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.DutyRosterDao;
import com.zqx.hospitalmanage.pojo.DutyRoster;
import com.zqx.hospitalmanage.service.DutyRosterService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.DutyRosterServiceImpl
 * @description:
 * @author: wangshu
 * @create: 2019-03-30 10:49:48
 **/
@Service
public class DutyRosterServiceImpl implements DutyRosterService {

    @Autowired
    private DutyRosterDao dutyRosterDao;

    @Override
    @Transactional
    public void saveAll(DutyRoster[] ds) {
        Date date = new Date();
        for (DutyRoster d : ds) {
            d.setId(Utils.getUUID());
            d.setOperationTime(date);
        }
        List<DutyRoster> list =  Arrays.asList(ds);
        dutyRosterDao.saveAll(list);
    }

    @Override
    public List<DutyRoster> findOneByDoctorId(String id) {
        List<DutyRoster> list = dutyRosterDao.findAllByDoctorId(id);
        long time = new Date().getTime();
        List<DutyRoster> l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(time - list.get(i).getStartTime().getTime() >= 0
                    && time - list.get(i).getStartTime().getTime() <= 14*24*60*60*1000 ){
                l.add(list.get(i));
            }
        }
        return l;
    }


}
