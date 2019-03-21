package com.zqx.hospitalmanage.controller;

import com.sun.codemodel.internal.util.UnicodeEscapeWriter;
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

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        return user.getName();
    }
    @RequestMapping("getUserInfo")
    @ResponseBody
    public Doctor getUserInfo(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        return user;
    }


    @RequestMapping("updatePwd")
    @ResponseBody
    public String  updatePwd(String pwd,String password,HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user.getPassword().equals(pwd)){
            doctorService.updatePassword(password,user.getId());
            user.setPassword(password);
//            session.setAttribute("user",user);
            return "success";
        }else {
            return "您输入的原密码错误";
        }

    }
}
