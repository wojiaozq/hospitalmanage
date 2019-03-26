package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Article;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ArticleService
 * @description:
 * @author:
 * @create: 2019-03-20 08:38:53
 **/
public interface ArticleService {
    public List<Article> findallByDoctorID(String doctorId);
    public List<Article> findLimit5(String doctorId);
    public int countByDoctorId(String doctorId);
    public void save(Article article);
}
