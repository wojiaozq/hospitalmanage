package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.PatientDao
 * @description: 病人
 * @author: wangshu
 * @create: 2019-03-24 11:55:24
 **/
public interface PatientDao  extends JpaRepository<Patient,String>, JpaSpecificationExecutor<Patient> {

    @Query(nativeQuery = true,value = "select * from Patient where name like ?;")
    public List<Patient> findByName(String name);
}
