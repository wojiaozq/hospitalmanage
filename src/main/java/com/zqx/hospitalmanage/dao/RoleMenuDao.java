package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @program: hospitalmanage.RoleMenuDao
 * @description:
 * @author:
 * @create: 2019-03-19 14:47:31
 **/
public interface RoleMenuDao extends JpaRepository<RoleMenu,String>, JpaSpecificationExecutor<RoleMenu> {
}
