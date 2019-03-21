package com.zqx.hospitalmanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zqx.hospitalmanage.pojo.Menu;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MenuDao extends JpaRepository<Menu,String>,JpaSpecificationExecutor<Menu>{

//    @Query(nativeQuery = true,value = "select * from menu where ;")

	
}
