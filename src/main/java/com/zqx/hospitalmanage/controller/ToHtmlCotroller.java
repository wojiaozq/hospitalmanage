package com.zqx.hospitalmanage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.zqx.hospitalmanage.pojo.*;
import com.zqx.hospitalmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ToHtmlCotroller
 * @description: 跳转html页面
 * @author:
 * @create: 2019-03-19 11:06:03
 **/
@Controller
public class ToHtmlCotroller {

    @Autowired
    private MenuService menuService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private CaseformService caseformService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LogService logService;

    @RequestMapping("myindex1")
    public String index(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user==null){
            return "您还未登录，请登录";//===>页面
        }
        return "myindex.html";
    }
    @RequestMapping("getMenu")
    @ResponseBody
    public String getMenu(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user==null){
            return "您还未登录，请登录";//===>页面
        }
        List<Role> role = user.getRole();
        Role role1 = role.get(0);
//        role1.getName()
        List<Menu> all = menuService.findAll(role1.getId());
        Object o = JSONObject.toJSON(all);
        System.out.println(o.toString());
        return role1.getName();
    }

    @RequestMapping("myindex")
    public List<Menu> toMyIndex(HttpSession session, Model model){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user==null){
            return null;//===>页面
        }
        List<Role> role = user.getRole();
        Role role1 = role.get(0);
//        role1.getName()
        List<Menu> all = menuService.findAll(role1.getId());//menu
        model.addAttribute("menu",all);
        return all;

    }

    @RequestMapping("Doctor_management.html")
    public String  getAllDoctor(Model model,HttpSession session){
        model.addAttribute("list",doctorService.findAll());
        return "Doctor_management.html";
    }
    //默认查找所有病人信息
    @RequestMapping("Patient_management.html")
    public String  getAllpatient(Model model){
        List<Patient> list = patientService.findAllpatient();
        model.addAttribute("puser",list);
        return "Patient_management.html";
    }
    //根据姓名查找病人
    @RequestMapping("select")
//    @ResponseBody
    public String selectPatientByName(String name,Model model){
        System.out.println("+++++++++++++++++");
        List<Patient> list1=patientService.selectPabyName(name);
        model.addAttribute("puser",list1);

        return "Patient_management.html";
    }

    @RequestMapping("Announcement_management.html")
    public String  getAllannou(Model model){
        List<Announcement> list = announcementService.findAll();
        model.addAttribute("annou",list);
        return "Announcement_management.html";
    }

    @RequestMapping("{page}")
    public String toPage(@PathVariable("page") String page, HttpSession session){
        Object user = session.getAttribute("user");
        if(user==null){
            return "您还未登录，请登录";//===>页面
        }
        return page;
    }

    @RequestMapping("findannoubyid")
    public String selectallannoubyid(Model model,String id){
        Announcement announcement=this.announcementService.findById(id);
        model.addAttribute("anuouview",announcement);
        return "/Announcementdetils.html";
    }
    //根据id查找病人和医生
    @RequestMapping("selPatientbyid")
    public String selectpatientById(String id,Model model){
        Patient patient=this.patientService.selepatient(id);
        model.addAttribute("pat",patient);
        Caseform caseform=this.caseformService.findbypid(id);
        model.addAttribute("case",caseform);
        return "/update_patient.html";
    }

    //根据主键查找医生
    @RequestMapping("doctorfindById")
    public String findOneById(String id, Model model){
        Doctor one = doctorService.findOneById(id);
        model.addAttribute("d",one);
        return "get_doctor.html";
    }

    @RequestMapping("Latest_articles.html")
    public String findLimitN(HttpSession session, Model model){
        Doctor user = (Doctor) session.getAttribute("user");
        List<Article> limit5 = articleService.findLimit5(user.getId());
        if(limit5==null){
            return "Latest_articles.html";
        }
        model.addAttribute("list",limit5);
        model.addAttribute("aname",user.getName());
        return "Latest_articles.html";
    }

    @RequestMapping("Article_record.html")
    public String findArticleAll(HttpSession session,Model model){
        Doctor user = (Doctor) session.getAttribute("user");
        List<Article> articles = articleService.findallByDoctorID(user.getId());
        model.addAttribute("list",articles);
        model.addAttribute("aname",user.getName());
        return "Article_record.html";
    }

    /*查找所有日志记录*/
    @RequestMapping("log.html")
    public String findallLog(Model model){
     List<Log> list=  logService.findallLog();
     model.addAttribute("log",list);
        return "log.html";
    }


}
