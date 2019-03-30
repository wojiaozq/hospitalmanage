package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Torder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.TorderDao
 * @description:  订单
 * @author:
 * @create: 2019-03-24 12:02:17
 **/
public interface TorderDao extends JpaRepository<Torder,String>, JpaSpecificationExecutor<Torder> {
}