package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ProblemDao
 * @description: 问题
 * @author:
 * @create: 2019-03-24 11:56:06
 **/
public interface ProblemDao  extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    @Query(nativeQuery = true ,value = "select * from problem where quizzer_id = ?;")
    public List<Problem> findByQuizzerId(String id);

    @Query(nativeQuery = true ,value = "select count (*) from problem ;")
    public int findallcount();
}
