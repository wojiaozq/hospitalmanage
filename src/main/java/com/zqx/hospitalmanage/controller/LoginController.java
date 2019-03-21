package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @program: hospitalmanage.LoginController
 * @description: 登录界面
 * @author:
 * @create: 2019-03-19 10:55:17
 **/

@Controller
public class LoginController {

    @Autowired
    private DoctorService doctorService;
//
    @RequestMapping("tologin")
    public String toLogin(){
        return "login";
    }
    @ResponseBody
    @RequestMapping(value = "loginDc",method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session){
        Doctor doctor = doctorService.login(username, password);
        if(doctor!=null){
            session.setAttribute("user",doctor);
            return "succes";
        }
        return "用户名或密码错误";
    }

}
