package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Enshrine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.EnshrineDao
 * @description: 收藏
 * @author: wangshu
 * @create: 2019-03-24 11:53:39
 **/
public interface EnshrineDao  extends JpaRepository<Enshrine,String>, JpaSpecificationExecutor<Enshrine> {
}
