package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.pojo.SolvePatient;
import com.zqx.hospitalmanage.service.SolvePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.SolveProblemController
 * @description:
 * @author:
 * @create: 2019-04-03 21:02:44
 **/
@Controller
@RequestMapping("solveProblem")
public class SolveProblemController {

    @Autowired
    private SolvePatientService solvePatientService;

    @RequestMapping("findByPId")
    @ResponseBody
    public List<SolvePatient> findByProblem(String problemId){
        return solvePatientService.findAllByProblem(problemId);
    }

    @RequestMapping("save")
    @ResponseBody
    public String save(SolvePatient solvePatient, HttpSession session){
        Patient puser = (Patient) session.getAttribute("puser");
        solvePatient.setPatientId(puser.getId());
        solvePatient.setPatientName(puser.getName());
        solvePatient.setTime(new Date());
        solvePatientService.add(solvePatient);
        return "success";
    }



}
