package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Evlauate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.EvlauateDao
 * @description: 评价
 * @author: wangshu
 * @create: 2019-03-24 11:54:43
 **/
public interface EvlauateDao  extends JpaRepository<Evlauate,String>, JpaSpecificationExecutor<Evlauate> {
}
