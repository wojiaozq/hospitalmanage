package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.LogDao;
import com.zqx.hospitalmanage.pojo.Log;
import com.zqx.hospitalmanage.service.LogService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    /*查找所有日志记录*/
    @Override
    public List<Log> findallLog() {

        return this.logDao.findAll();
    }
    /*添加一条日志记录*/
    @Override
    public void addlog(Log log) {
        log.setId(Utils.getUUID());
        Date t=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         log.setTime( df.format(t));
        this.logDao.save(log);
    }
}
