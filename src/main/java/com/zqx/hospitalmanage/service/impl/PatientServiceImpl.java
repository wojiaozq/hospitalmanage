package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.CaseformDao;
import com.zqx.hospitalmanage.dao.PatientDao;
import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.service.PatientService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    /*@Autowired
    private CaseformDao caseformDao;*/

   String uid=Utils.getUUID();

    @Override
    public void addpatient(Patient patient, Caseform caseform) {
        patient.setId(uid);
        caseform.setPatientId(uid);
        this.patientDao.save(patient);

    }

    @Override
    public void delpatient(String id) {
        patientDao.deleteById(id);
    }

    @Override
    public Patient selepatient(String id) {
         return patientDao.findById(id).get();
    }

    @Override
    public void updatepatient(Patient patient) {
            this.patientDao.save(patient);
    }

    @Override
    public List<Patient> findAllpatient() {

        return this.patientDao.findAll();
    }

}
