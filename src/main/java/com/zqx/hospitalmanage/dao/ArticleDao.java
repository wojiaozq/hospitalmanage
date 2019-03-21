package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Announcement;
import com.zqx.hospitalmanage.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ArticleDao
 * @description: 文章-->持久层接口
 * @author:
 * @create: 2019-03-19 19:59:38
 **/
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    //根据医生id查询公告
    @Query(nativeQuery = true,value = "select * from Article where person_id = ?;")
    public List<Article> findByDoctorId(String psersonId);

    //根据时间段查询文章
    @Query(nativeQuery = true,value = "select * from Article where time >= ? and time <= ?;")
    public List<Article> findByTime(Date startDate, Date endDate);

    //根据某一个时间值，查询该时间当前时间的文章
    @Query(nativeQuery = true,value = "select * from Article where time >= ?;")
    public List<Article> findByGtTime(Date startDate);

}
