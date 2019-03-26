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

    @Query(value = "select e.id id, e.context context, e.case_id case_id,e.timer timer from caseform c left join evlauate e on c.id = e.case_id and c.doctor_id = ?;",nativeQuery = true)
    public List<Evlauate> findByDoctorId(String doctorId);

}
