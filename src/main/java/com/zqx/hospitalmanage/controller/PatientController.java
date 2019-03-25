package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.service.CaseformService;
import com.zqx.hospitalmanage.service.PatientService;
import org.aspectj.weaver.patterns.ThisOrTargetPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private CaseformService caseformService;

    @RequestMapping("save")
    @ResponseBody
    public String insertPatient(Patient patient, Caseform caseform){
        this.patientService.addpatient(patient);
        this.caseformService.addcaseform(caseform);
        return "success";
    }



}
