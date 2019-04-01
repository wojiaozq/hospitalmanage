package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.DutyRoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.DutyRosterDao
 * @description:
 * @author:
 * @create: 2019-03-30 10:46:35
 **/
public interface DutyRosterDao extends JpaRepository<DutyRoster,String>, JpaSpecificationExecutor<DutyRoster> {

    @Query(nativeQuery = true,value = "select * from duty_roster where doctor_id = ?;")
    public List<DutyRoster> findAllByDoctorId(String doctorId);



}
