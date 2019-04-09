package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.PatientDao;
import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.pojo.vo.PatientreVo;
import com.zqx.hospitalmanage.service.PatientService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    @Override
    public void addpatient(Patient patient, Caseform caseform) {
        String uid=Utils.getUUID();
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

    @Override
    public List<Patient> selectPabyName(String name) {
        String name1="%"+name+"%";
        return this.patientDao.findByName(name1);
    }

    @Override
    public void addonepatient(Patient patient) {
        patient.setId(Utils.getUUID());
        this.patientDao.save(patient);
    }

    @Override
    public Patient findPlogin(String identification, String password) {
        return  this.patientDao.findByUsnameAndPassword(identification,password);
    }

    @Override
    public Patient findpatientByid(String id) {
        return this.patientDao.findById(id).get();
    }

    @Override
    public void uppwd(String id, String password) {
        this.patientDao.updatePassword(id,password);
    }



}
