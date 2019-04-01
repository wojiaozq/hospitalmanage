package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.DutyRoster;
import com.zqx.hospitalmanage.service.DutyRosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @program: hospitalmanage.DutyRosterContoller
 * @description:
 * @author: wangshu
 * @create: 2019-03-30 11:49:46
 **/
@Controller
@RequestMapping("dutyRoster")
public class DutyRosterContoller {

    @Autowired
    private DutyRosterService dutyRosterService;

    @RequestMapping("save")
    @ResponseBody
    public String saveAll(@RequestBody  DutyRoster[] dutyRosters){
//        for (DutyRoster dutyRoster : dutyRosters) {
//            System.out.println(dutyRoster);
//        }
        dutyRosterService.saveAll(dutyRosters);
        return "success";
    }



}
