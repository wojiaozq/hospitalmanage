package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Caseform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.CaseformDao
 * @description:
 * @author: wangshu
 * @create: 2019-03-24 11:52:29
 **/
public interface CaseformDao extends JpaRepository<Caseform,String >, JpaSpecificationExecutor<Caseform> {
    /**/
}
