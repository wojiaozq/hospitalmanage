package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Log;

import java.util.List;

public interface LogService {
    public List<Log>findallLog();
    public void addlog(Log log);
}
