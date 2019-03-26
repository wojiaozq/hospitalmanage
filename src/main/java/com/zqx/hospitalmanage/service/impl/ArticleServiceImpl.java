package com.zqx.hospitalmanage.service.impl;

import com.zqx.hospitalmanage.dao.ArticleDao;
import com.zqx.hospitalmanage.pojo.Article;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.service.ArticleService;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ArticleServiceImpl
 * @description:
 * @author:
 * @create: 2019-03-20 08:39:09
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Transactional
    public void save(Article article){
        article.setId(Utils.getUUID());
        article.setTime(new Date());
        articleDao.save(article);
    }


    //查询所有文章
    public List<Article> findallByDoctorID(String doctorId){
        return articleDao.findAllOrederByTimer(doctorId);
    }
    //查询最新的文章5篇
    public List<Article> findLimit5(String doctorId){
        List<Article> list = articleDao.findAllOrederByTimer(doctorId);
        List<Article> l = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            l.add(list.get(i));
        }
        return l;
    }
    //统计本人发布的文章
    public int countByDoctorId(String doctorId){
        return articleDao.countByPersonId(doctorId);
    }
}
