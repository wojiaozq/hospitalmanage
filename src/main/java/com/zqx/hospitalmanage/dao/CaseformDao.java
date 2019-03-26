package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Caseform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @version 1.0
 * @program: hospitalmanage.CaseformDao
 * @description:
 * @author: wangshu
 * @create: 2019-03-24 11:52:29
 **/
public interface CaseformDao extends JpaRepository<Caseform,String >, JpaSpecificationExecutor<Caseform> {

    //根据医生病人id删除病历
    @Modifying
     @Query(nativeQuery = true,value = "delete from caseform where patient_id =?")
    public void delBypidcaseform(String patientId);

    //根据病人id查找病历信息
    @Query(nativeQuery = true,value = "select * from caseform where patient_id =?")
    public Caseform selBypidcaseform(String patientId);

   /* @Query(nativeQuery = true,value = "update caseform set time=?,diagnosisInfo=? ,main_Suit=?,present_Illness=?,previous_History=?,cure_Means=?,allergy=? where patient_Id=?")
    public Caseform upBypidcaseform(String patient_Id);*/

}
