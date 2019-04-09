package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.pojo.vo.PatientreVo;

import java.util.Date;
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
        public void uppwd(String id,String password);

     //   public List<PatientreVo>selpareg(String doctorid, Date date);//根据医生id查找挂号记录

}
