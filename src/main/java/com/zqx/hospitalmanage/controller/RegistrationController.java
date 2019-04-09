package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Evlauate;
import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.service.EvlauateService;
import com.zqx.hospitalmanage.service.RegistrationService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.RegistrationController
 * @description:
 * @author:
 * @create: 2019-03-24 16:37:07
 **/
@Controller
@RequestMapping("registration")
public class RegistrationController {

   @Autowired
    private RegistrationService registrationService;
   @Autowired
    private EvlauateService evlauateService;

    @RequestMapping("addguahao")
    public String addregis(Registration registration,Evlauate evlauate){
        registrationService.addRegistration(registration);
        evlauate.setDoctorid(registration.getDoctorid());
        evlauate.setDoctorname(registration.getDoctorName());
        evlauate.setPid(registration.getPatientId());
        evlauate.setCommentator(registration.getPatientName());
        evlauateService.add(evlauate);
         return "redirect:/geren.html";
    }
}
