package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.CaseformDao;
import com.zqx.hospitalmanage.dao.PatientDao;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.service.PatientService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    @Override
    public void addpatient(Patient patient) {
        patient.setId(Utils.getUUID());
        this.patientDao.save(patient);
    }

    @Override
    public void delpatient(String id) {

    }

    @Override
    public void selepatient(String id) {

    }

    @Override
    public void updatepatient(Patient patient) {

    }

    @Override
    public List<Patient> findAllpatient(Patient patient) {
        return null;
    }
}
