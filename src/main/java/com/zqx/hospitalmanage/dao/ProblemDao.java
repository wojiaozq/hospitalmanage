package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.ProblemDao
 * @description: 问题
 * @author: wangshu
 * @create: 2019-03-24 11:56:06
 **/
public interface ProblemDao  extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {
}
