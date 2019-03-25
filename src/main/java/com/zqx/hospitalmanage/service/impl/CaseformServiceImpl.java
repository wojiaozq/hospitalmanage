package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.CaseformDao;
import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.service.CaseformService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaseformServiceImpl implements CaseformService {
    @Autowired
    private CaseformDao caseformDao;
    @Override
    public void addcaseform(Caseform caseform) {
        caseform.setId(Utils.getUUID());
        this.caseformDao.save(caseform);

    }

    @Override
    public void delcaseform(String id) {

    }

    @Override
    public void selecaseform(String id) {

    }

    @Override
    public void updatecaseform(Caseform caseform) {

    }

    @Override
    public List<Caseform> findall() {
        return null;
    }
}
