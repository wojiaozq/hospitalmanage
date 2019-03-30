package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.DoctorController
 * @description:
 * @author:
 * @create: 2019-03-19 17:03:45
 **/
@Controller
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //添加一名医生--注册
    @RequestMapping("save")
    @ResponseBody
    public String addDoctor( Doctor doctor){
        System.out.println(doctor);
        doctorService.add(doctor);
        return "success";
    }
    //一名医生--修改
    @RequestMapping("update")
    @ResponseBody
    public String updateDoctor(Doctor doctor){
//        System.out.println(doctor);
        doctorService.update(doctor);
        return "success";
    }

    //NowUpdate
    @RequestMapping("NowUpdate")
    @ResponseBody
    public String nowUpdateDoctor(Doctor doctor, HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        user.setTel(doctor.getTel());
        user.setAddress(doctor.getAddress());
        user.setName(doctor.getName());
        user.setBirthday(doctor.getBirthday());
        user.setAge(doctor.getAge());
        doctorService.update(user);
        return "success";
    }

    //检查用户名是否可用
    @RequestMapping("checkUsername")
    @ResponseBody
    public String checkUsername(String username){
        if(doctorService.checkUsername(username)){
            return "可用";
        }else{
            return "不可用";
        }
    }



    //根据姓名查找医生
    @RequestMapping("FindByName")
    @ResponseBody
    public List<Doctor> findAllByName(String name){
        return doctorService.getDoctorByName(name);
    }

    @RequestMapping("search")
    @ResponseBody
    public List<Doctor> findByStartEndName(String name,String start,String end){
        return doctorService.findByNameAndStartAndEnd(name,start,end);
    }
    //分页
    @RequestMapping("page")
    @ResponseBody
    public Page<Doctor> findAllByPage(int now,int size){
        return doctorService.findAllByPage(now,size);
    }

    //查询所有医生
    @RequestMapping("all")
    @ResponseBody
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }


    //删除一名医生
    @RequestMapping("delete")
    @ResponseBody
    public String  delete(String id){
        doctorService.updateStatus(id);
        return "success";
    }


}
