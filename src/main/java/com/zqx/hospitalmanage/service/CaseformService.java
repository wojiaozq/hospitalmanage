package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Caseform;

import java.util.List;

public interface CaseformService {
    public void addcaseform(Caseform caseform);
    public void delcaseform(String id);
    public Caseform findbypid(String id);//通过病人id
    public Caseform selecaseform(String id);//通过主键
    public void updatecaseform(Caseform caseform);
    public List<Caseform> findall();
}
