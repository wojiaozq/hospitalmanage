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
 * @author:
 * @create: 2019-03-24 11:57:08
 **/
public interface RegistrationDao extends JpaRepository<Registration,String>, JpaSpecificationExecutor<Registration> {

   @Query(nativeQuery = true,value = "select * from registration where doctor_id = ? and mytime>=? ;")
   public List<Registration> findByDoctorId(String id,Date date);

   @Query(nativeQuery = true,value = "select count(*) from registration where doctor_id = ?")
   public int findcountbyid(String doctorid);

   @Query(nativeQuery = true,value = "select count(*) from registration where doctor_id = ? and mytime>=?")
   public int findcountlast(String doctorid,Date date);

   @Query(nativeQuery = true,value = "select * from registration where patient_id = ?")
   public List<Registration> findbypatientid(String patientId);

   @Query(nativeQuery = true,value = "select count(*) from registration where doctor_id = ? and mytime=?")
   public int findcountdatecount(String doctorid,Date date);
}
