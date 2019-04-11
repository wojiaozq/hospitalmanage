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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @ResponseBody
    public String addregis(Registration registration,Evlauate evlauate) throws ParseException {
        String otime=(registration.getTimedetails()).substring(0,10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf.parse(otime);
        Date date2=new Date();
        if(date1.compareTo(date2)<0){
            /*beginTime.compareTo(endTime)<0时，开始时间小于结束时间 */
            return "error";
        }if ((registrationService.seltimecount(registration.getDoctorid(),date2))>20){
            return "tolong";
        }
        registrationService.addRegistration(registration);
        evlauate.setDoctorid(registration.getDoctorid());
        evlauate.setDoctorname(registration.getDoctorName());
        evlauate.setPid(registration.getPatientId());
        evlauate.setCommentator(registration.getPatientName());
        evlauateService.add(evlauate);
        return "success";
    }
}
