package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.service.PatientService;
import com.zqx.hospitalmanage.service.RegistrationService;
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
    private RegistrationService registrationService;

    @RequestMapping("save")
    @ResponseBody
    public String insertPatient(Patient patient){

        if (patientService.selbyident(patient.getIdentification())!=null){
            return "error";
        }
          this.patientService.addpatient(patient);
          return "success";
    }

    @RequestMapping("delPatientbyid")
    public String delpatient(String id){
        this.patientService.delpatient(id);
        String pid=id;
        this.registrationService.delrebypid(pid);
        return "redirect:/Patient_management.html";
    }

    @RequestMapping("updateByid")
    public String uppatient(Patient patient){
        this.patientService.updatepatient(patient);
        return "redirect:/Patient_management.html";
    }

    @RequestMapping("pregpa")
    public String regpatient(Patient patient,HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser!=null){
            session.removeAttribute("puser");
        }if (patientService.selbyident(patient.getIdentification())==null){
            this.patientService.addonepatient(patient);
            return "redirect:/plogin.html";
        }
        return "404.html";
    }

    @RequestMapping("idcard")
    @ResponseBody
    public  String selidcard(String identification){
        if (patientService.selbyident(identification)==null){
            return "success";
        }
        return "error";
    }


    @RequestMapping("uppatientmyself")
    public String updatepatient(Patient patient,HttpSession session){
        Patient patient1=(Patient) session.getAttribute("puser");
        patient.setId(patient1.getId());
        this.patientService.updatepatient(patient);
        return "redirect:/geren.html";
    }


}
