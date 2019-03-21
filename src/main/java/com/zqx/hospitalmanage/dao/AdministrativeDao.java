package com.zqx.hospitalmanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zqx.hospitalmanage.pojo.Administrative;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AdministrativeDao extends JpaRepository<Administrative,String>,JpaSpecificationExecutor<Administrative>{
	
}
