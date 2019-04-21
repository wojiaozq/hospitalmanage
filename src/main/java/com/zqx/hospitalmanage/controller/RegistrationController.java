package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Evlauate;
import com.zqx.hospitalmanage.pojo.Registration;
import com.zqx.hospitalmanage.service.EvlauateService;
import com.zqx.hospitalmanage.service.RegistrationService;
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

   String Doctorid;
   String Doctorname;
   String pid;
   String Commentator;
    @RequestMapping("addguahao")
    @ResponseBody
    public String addregis(Registration registration) throws ParseException {
        String otime=(registration.getTimedetails()).substring(0,10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf.parse(otime);
        Date date2=new Date();
        String s = sdf.format(new Date());
        Date newsdate=sdf.parse(s);
        if(date1.compareTo(date2)<0){
            return "error";
        }if ((registrationService.seltimecount(registration.getDoctorid(),newsdate))>20){
            return "tolong";
        }
       Registration re=registrationService.selbydateandpid(registration.getPatientId(),registration.getTimedetails());
        if(re!=null){
            return "repeat";
        }
        registrationService.addRegistration(registration);
        Doctorid=registration.getDoctorid();
        Doctorname=registration.getDoctorName();
        pid =registration.getPatientId();
        Commentator=registration.getPatientName();

        return "success";
    }

    @RequestMapping("okreg")
    @ResponseBody
    public String upreg(String id,Evlauate evlauate){
        this.registrationService.updregis(id);
        evlauate.setDoctorid(Doctorid);
        evlauate.setDoctorname(Doctorname);
        evlauate.setPid(pid);
        evlauate.setCommentator(Commentator);
        evlauateService.add(evlauate);
        return "success";
    }
}
