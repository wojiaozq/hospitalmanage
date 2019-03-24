package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.SolveDocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.SoleveDoctorDao
 * @description: 问题-->医生解决
 * @author: wangshu
 * @create: 2019-03-24 11:58:05
 **/
public interface SolveDoctorDao extends JpaRepository<SolveDocker,String>, JpaSpecificationExecutor<SolveDocker> {
}