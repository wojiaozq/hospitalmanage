package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Announcement;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping("addannou")
    @ResponseBody
    public String addannouncement(Announcement announcement,HttpSession session){
        Doctor doctor=(Doctor)session.getAttribute("user");
        String personName=doctor.getName();
        String personId=doctor.getId();
        announcement.setPersonId(personId);
        announcement.setPersonName(personName);
        announcement.setReleaseTime(new Date());
        this.announcementService.add(announcement);
        return "success";
    }



    @RequestMapping("deleannoubyid")
    public String DeleteannouById(String id){
        this.announcementService.delete(id);
        return "redirect:/Announcement_management.html";
    }
}
