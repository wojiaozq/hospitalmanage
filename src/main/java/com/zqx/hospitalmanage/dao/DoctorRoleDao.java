package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.DoctorRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @version 1.0
 * @program: hospitalmanage.DoctorRoleDao
 * @description:
 * @author:
 * @create: 2019-03-19 14:46:47
 **/
public interface DoctorRoleDao extends JpaRepository<DoctorRole,String>, JpaSpecificationExecutor<DoctorRole> {
    @Query(nativeQuery = true,value = "select * from doctor_role where doctor_id = ?;")
    public DoctorRole findByDoctorId(String doctorId);

}
