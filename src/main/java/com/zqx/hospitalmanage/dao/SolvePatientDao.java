package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.SolvePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.SolvePatientDao
 * @description: 问题 -- >病人解决
 * @author: wangshu
 * @create: 2019-03-24 12:01:44
 **/
public interface SolvePatientDao extends JpaRepository<SolvePatient,String>, JpaSpecificationExecutor<SolvePatient
        > {
}