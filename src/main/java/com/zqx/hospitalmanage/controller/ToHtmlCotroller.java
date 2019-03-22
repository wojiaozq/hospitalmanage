package com.zqx.hospitalmanage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zqx.hospitalmanage.pojo.Announcement;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Menu;
import com.zqx.hospitalmanage.pojo.Role;
import com.zqx.hospitalmanage.service.AnnouncementService;
import com.zqx.hospitalmanage.service.DoctorService;
import com.zqx.hospitalmanage.service.MenuService;
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
    public String  getAllDoctor(Model model){
        model.addAttribute("list",doctorService.findAll());
        return "Doctor_management.html";
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

}
