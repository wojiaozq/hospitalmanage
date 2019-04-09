package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Evlauate;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.EvlauateDao
 * @description: 评价
 * @author:
 * @create: 2019-03-24 11:54:43
 **/
public interface EvlauateDao  extends JpaRepository<Evlauate,String>, JpaSpecificationExecutor<Evlauate> {

    @Query(nativeQuery = true,value = "select * from evlauate where context is null")
    public List<Evlauate> findallnull();

    @Query(nativeQuery = true,value = "select * from evlauate where doctorid = ? and context is not null ")
    public List<Evlauate> findallbyid(String doctorid);

    @Query(nativeQuery = true,value = "select count(*) from evlauate where doctorid = ?")
    public int findcountbyid(String doctorid);

}
