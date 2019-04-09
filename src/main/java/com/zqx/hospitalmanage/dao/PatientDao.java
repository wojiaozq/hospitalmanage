package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Patient;
import com.zqx.hospitalmanage.pojo.vo.PatientreVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
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

    @Query(nativeQuery = true,value = "select * from Patient where identification = ? and password = ?")
    public Patient findByUsnameAndPassword(String identification, String password);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update Patient set password = ? where id =?;")
    public void updatePassword(String password, String id);

    /*@Query(nativeQuery = true,value = "select * from (select p.name,p.Identification,p.sex,p.age,p.tel,p.address,r.timedetails,r.doctor_id ,r.mytime from\n" +
            " Patient p, registration r where p.id=r.patient_id) as c where doctor_id= ? AND mytime>= ?;")
    public List<PatientreVo> findAllpareginfo(String doctorid, Date date);*/


}
