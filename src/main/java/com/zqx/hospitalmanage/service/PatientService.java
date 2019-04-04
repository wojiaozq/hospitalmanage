package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.pojo.Patient;

import java.util.List;

public interface PatientService {
        public void addpatient(Patient patient,Caseform caseform);
        public void delpatient(String id);
        public Patient selepatient(String id);
        public void updatepatient(Patient patient);
        public List<Patient> findAllpatient();
        public List<Patient> selectPabyName(String name);
        public void addonepatient(Patient patient);
        public Patient findPlogin(String identification,String password);
        public Patient findpatientByid(String id);

}
