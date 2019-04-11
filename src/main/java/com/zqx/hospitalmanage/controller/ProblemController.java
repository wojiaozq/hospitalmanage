package com.zqx.hospitalmanage.controller;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.pojo.Problem;
import com.zqx.hospitalmanage.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ProblemController
 * @description:
 * @author:
 * @create: 2019-04-03 12:47:14
 **/
@Controller
@RequestMapping("problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("add")
    @ResponseBody
    public String addP(Problem problem, HttpSession session){
        Patient puser = (Patient) session.getAttribute("puser");
        String id = puser.getId();
        String name = puser.getName();
        problem.setQuizzerId(id);
        problem.setQuizzerName(name);
        problemService.save(problem);
        return "success";
    }
    @RequestMapping("findByP")
    @ResponseBody
    public List<Problem> findByPatientId(HttpSession session){
        Patient puser = (Patient) session.getAttribute("puser");
        String id = puser.getId();
        return problemService.findByPatientId(id);
    }

    @RequestMapping("all")
    @ResponseBody
    public List<Problem> all(){
        return problemService.findAll();
    }

    @RequestMapping("findalotof")
    @ResponseBody
    public int findallcount(){
        int k=problemService.findallcount();
        return k;
    }

}
