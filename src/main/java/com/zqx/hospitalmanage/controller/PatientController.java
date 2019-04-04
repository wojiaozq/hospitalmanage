package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Caseform;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.service.CaseformService;
import com.zqx.hospitalmanage.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private CaseformService caseformService;

    @RequestMapping("save")
    @ResponseBody
    public String insertPatient(Patient patient, Caseform caseform, HttpSession session){
        Doctor doctor=(Doctor)session.getAttribute("user");
        String doctorId=doctor.getId();
        caseform.setDoctorId(doctorId);
        this.patientService.addpatient(patient,caseform);
        this.caseformService.addcaseform(caseform);
        return "success";
    }

    @RequestMapping("delPatientbyid")
    public String delpatient(String id){
        this.caseformService.delcaseform(id);
        this.patientService.delpatient(id);
        return "redirect:/Patient_management.html";
    }

    @RequestMapping("updateByid")
    public String uppatient(Patient patient, Caseform caseform){
        patient.setId(caseform.getPatientId());
        this.patientService.updatepatient(patient);
        this.caseformService.updatecaseform(caseform);
        return "redirect:/Patient_management.html";
    }

    @RequestMapping("pregpa")
    public String regpatient(Patient patient){
        this.patientService.addonepatient(patient);
        return "redirect:/plogin.html";
    }

    @RequestMapping("uppatientmyself")
    public String updatepatient(Patient patient,HttpSession session){
        Patient patient1=(Patient) session.getAttribute("puser");
        patient.setId(patient1.getId());
        this.patientService.updatepatient(patient);
        return "redirect:/geren.html";
    }

}
