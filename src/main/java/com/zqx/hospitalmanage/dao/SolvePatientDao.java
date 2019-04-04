package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.SolvePatient;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.SolvePatientDao
 * @description: 问题 -- >病人解决
 * @author:
 * @create: 2019-03-24 12:01:44
 **/
public interface SolvePatientDao extends JpaRepository<SolvePatient,String>, JpaSpecificationExecutor<SolvePatient> {

    //查詢某個問題的所有回答
    @Query(nativeQuery = true,value = "select * from hospital.solve_patient where problem_id=?;")
    public List<SolvePatient> findAllByProblemId(String problemId);

}