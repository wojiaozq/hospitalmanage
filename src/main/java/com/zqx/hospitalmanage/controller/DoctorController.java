package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Log;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
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
    @Autowired
    private LogService logService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private EvlauateService evlauateService;

    //添加一名医生--注册
    @RequestMapping("save")
    @ResponseBody
    public String addDoctor(Doctor doctor,HttpSession session){
        Doctor doctor1=(Doctor)session.getAttribute("user");
        doctorService.add(doctor);
        return "success";
    }
    //一名医生--修改
    @RequestMapping("update")
    @ResponseBody
    public String updateDoctor(Doctor doctor){
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
    public String  delete(String id,Log log,HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        doctorService.updateStatus(id);
        Doctor doctor=doctorService.findOneById(id);
        if (doctor.getStatus().equals("离职")){
            log.setContent("恢复编号为"+id+"的医生");
        }else{
            log.setContent("删除编号为"+id+"的医生");
        }
        log.setOperator(user.getName());
        logService.addlog(log);
        return "success";
    }

    @RequestMapping("countAll")
    @ResponseBody
    public String  count(){
        return doctorService.countAllByStatus()+"";
    }

    @RequestMapping("allStatus")
    @ResponseBody
    public List<Doctor> allStatus(){
        return doctorService.findAllStats();
    }

    @RequestMapping("admini")
    @ResponseBody
    public List<Doctor> findByAdministrativeId(String aId){
        return doctorService.findAllByAdministrative(aId);
    }
    //查找在职医生
    @RequestMapping("findalot")
    @ResponseBody
    public int findcount(){
       int i= doctorService.findcountzz("在职");

       return i;
    }

    //查找医生最近预约人数
    @RequestMapping("findlast")
    @ResponseBody
    public int findcougecoun(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天，如果是后两天就+2
        Date date = calendar.getTime();
        int i= registrationService.finddoctorlastcount(user.getId(),date);

        return i;
    }

    //查找医生旗下挂号总人数
    @RequestMapping("findreconutall")
    @ResponseBody
    public int selcoureg(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        int j= registrationService.finddoctorallcount(user.getId());
        return j;
    }

    // 查找医生被评论的总数量
    @RequestMapping("findevcountall")
    @ResponseBody
    public int findcounev(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        int k= evlauateService.findcount(user.getId());
        return k;
    }


}
