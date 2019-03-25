package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Caseform;

import java.util.List;

public interface CaseformService {
    public void addcaseform(Caseform caseform);
    public void delcaseform(String id);
    public void selecaseform(String id);
    public void updatecaseform(Caseform caseform);
    public List<Caseform> findall();
}
