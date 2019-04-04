package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("addguahao")
    public String addregis(Registration registration){
        registrationService.addRegistration(registration);
       return "redirect:/geren.html";
    }
}
