package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Administrative;
import com.zqx.hospitalmanage.service.AdministrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.AdministrativeController
 * @description:
 * @author:
 * @create: 2019-03-20 15:39:26
 **/
@Controller
@RequestMapping("administrative")
public class AdministrativeController {

    @Autowired
    private AdministrativeService administrativeService;

    @RequestMapping("getAll")
    @ResponseBody
    public List<Administrative> getAll(){
        return administrativeService.findAll();
    }


}
