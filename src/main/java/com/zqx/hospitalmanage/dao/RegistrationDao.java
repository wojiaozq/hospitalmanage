package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.RegistrationDao
 * @description:
 * @author: wangshu
 * @create: 2019-03-24 11:57:08
 **/
public interface RegistrationDao extends JpaRepository<Registration,String>, JpaSpecificationExecutor<Registration> {
    //根据医生主键查询，该医生下的挂号信息
    @Query(nativeQuery = true,value = "select * from registration where doctor_id = ?;")
    public List<Registration> findByDoctorId(String id);
    //根据患者姓名查询挂号信息
    @Query(nativeQuery = true,value = "select * from registration where doctor_name like ?;")
    public List<Registration> findByPatientName(String name);

    @Modifying
    @Query(nativeQuery = true,value = "update registration set status = ? where id = ?;")
    public void updateStatus(int status, String id);

    //查询在某一时间后的预约记录计数
    public int countByBookingPeriodAfter(Date date);


}
