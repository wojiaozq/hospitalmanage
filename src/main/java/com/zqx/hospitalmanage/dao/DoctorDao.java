package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Doctor;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.print.Doc;
import javax.swing.*;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.DoctorDao
 * @description: 持久层
 * @author:
 * @create: 2019-03-19 12:44:02
 **/
public interface DoctorDao extends JpaRepository<Doctor,String >, JpaSpecificationExecutor<Doctor> {

    @Query(nativeQuery = true,value = "select * from doctor where username = ? and password = ?")
    public Doctor findByUsernameAndPassword(String username,String password);

    @Query(nativeQuery = true,value = "select * from doctor where username like ?;")
    public List<Doctor> findLikeUsername(String username);//username在数据库中唯一，用于登录

    @Query(nativeQuery = true,value = "select * from doctor where username = ?;")
    public List<Doctor> findByUsername(String username);

    @Query(nativeQuery = true,value = "select * from doctor where name = ?;")
    public List<Doctor> findByName(String name);

    @Query(nativeQuery = true,value = "select * from doctor limit ?,?;")
    public List<Doctor> findAllByPage(int start,int end);

//    @Query(nativeQuery = true,value = "select count(id) from doctor;")
//    public int count();
    //查询获取VO对象
    @Query(nativeQuery = true,value = "select d.id ,d.name,d.job,a.name administrativeName,d.entry_time,d.sex,d.status,d.tel  from doctor d left join administrative a on d.administrative_id = a.id;")
    public List<Object[]> findAllDoctorVO();

}