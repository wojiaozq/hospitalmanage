package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LogDao  extends JpaRepository<Log,String>, JpaSpecificationExecutor<Log> {


}
