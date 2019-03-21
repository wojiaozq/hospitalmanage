package com.zqx.hospitalmanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zqx.hospitalmanage.pojo.Role;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RoleDao extends JpaRepository<Role,String>,JpaSpecificationExecutor<Role>{

    @Query(nativeQuery = true,value = "select * from role where name = ?;")
    public Role findByName(String name);
}
