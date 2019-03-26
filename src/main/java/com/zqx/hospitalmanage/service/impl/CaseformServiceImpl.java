package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.CaseformDao;
import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.service.CaseformService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public void delcaseform(String id) {
        this.caseformDao.delBypidcaseform(id);
    }

    @Override
    public Caseform findbypid(String id) {
        return this.caseformDao.selBypidcaseform(id);
    }

    @Override
    public Caseform selecaseform(String id) {

        return null;
    }

    @Override
    public void updatecaseform(Caseform caseform) {
            Caseform caseform1=this.caseformDao.selBypidcaseform(caseform.getPatientId());
            caseform.setId(caseform1.getId());
            this.caseformDao.save(caseform);
    }

    @Override
    public List<Caseform> findall() {
        return null;
    }
}
