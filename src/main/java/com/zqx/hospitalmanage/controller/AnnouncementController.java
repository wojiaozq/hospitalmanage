package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Announcement;
import com.zqx.hospitalmanage.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("Announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping("addannou")
    @ResponseBody
    public String addannouncement(Announcement announcement ){
        this.announcementService.add(announcement);
        return "success";
    }
    @RequestMapping("findallannou")
    public List<Announcement> selectallannou(){
        return this.announcementService.findAll();
    }
}
