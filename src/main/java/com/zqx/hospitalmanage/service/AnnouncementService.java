package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Announcement;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.AnnouncementService
 * @description: 服务层
 * @author:
 * @create: 2019-03-20 08:38:17
 **/
public interface AnnouncementService {

    public Announcement findById(String id);
    public List<Announcement> findAll();
    public Page<Announcement> findByPage(int now, int size);
    public List<Announcement> likeTopic(String topic);
    public void add(Announcement announcement);
    public void update(Announcement announcement);
    public void delete(String id);
}
