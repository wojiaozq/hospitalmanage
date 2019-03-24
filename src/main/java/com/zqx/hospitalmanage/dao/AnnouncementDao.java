package com.zqx.hospitalmanage.dao;

import com.zqx.hospitalmanage.pojo.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.AnnouncementDao
 * @description: 公告-->持久层
 * @author:
 * @create: 2019-03-19 20:01:00
 **/
public interface AnnouncementDao extends JpaRepository<Announcement,String>, JpaSpecificationExecutor<Announcement> {

    @Query(nativeQuery = true,value ="select * from announcement where release_time ;")
    public Announcement findByReleaseTimeMax();

    //根据医生id查询公告
    @Query(nativeQuery = true,value = "select * from announcement where person_id = ?;")
    public List<Announcement> findByDoctorId(String psersonId);

    //根据时间段查询公告
    @Query(nativeQuery = true,value = "select * from announcement where release_time >= ? and release_time <= ?;")
    public List<Announcement> findByReleaseTime(Date startDate, Date endDate);

    //根据某一个时间值，查询该时间当前时间的公告
    @Query(nativeQuery = true,value = "select * from announcement where release_time >= ?;")
    public List<Announcement> findByGtReleaseTime(Date startDate);

    @Query(nativeQuery = true,value = "select * from announcement limit ?,?;")
    public List<Announcement> findByPage(int start, int end);

    @Query(nativeQuery = true,value = "select * from announcement where topic like ?;")
    public List<Announcement> findLikeTopic(String topic);


}
