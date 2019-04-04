package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.AnnouncementDao;
import com.zqx.hospitalmanage.pojo.Announcement;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.service.AnnouncementService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.AnnouncementServiceImpl
 * @description:
 * @author:
 * @create: 2019-03-20 08:38:34
 **/
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    @Autowired
    private Page<Announcement> page;

    public Announcement findById(String id){
        return announcementDao.findById(id).get();
    }

    public List<Announcement> findAll(){

        return announcementDao.findAll();
    }

    @Override
    public List<Announcement> findannBytime(Date date) {

        return this.announcementDao.findByGtReleaseTime(date);
    }

    public Page<Announcement> findByPage(int now,int size){
        long count = announcementDao.count();
        page.setData(announcementDao.findByPage((now-1)*size,size*now));
        page.setNum((int) count);
        page.setSize(size);
        page.setNow(now);
        page.setTotal(Utils.pageTotal(page.getNum(),size));
        page.setLast(page.getTotal());
        return page;
    }
    public List<Announcement> likeTopic(String topic){
        return announcementDao.findLikeTopic('%'+topic+'%');
    }
    @Transactional
    public void add(Announcement announcement){
        announcement.setId(Utils.getUUID());
        announcementDao.save(announcement);
    }
    @Transactional
    public void update(Announcement announcement){
        announcementDao.save(announcement);
    }
    @Transactional
    public void delete(String id){
        announcementDao.deleteById(id);
    }


}
