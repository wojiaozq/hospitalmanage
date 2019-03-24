package com.zqx.hospitalmanage.controller;

import com.zqx.hospitalmanage.pojo.Article;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @program: hospitalmanage.ArticleController
 * @description:
 * @author:
 * @create: 2019-03-22 16:15:39
 **/
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("add")
    @ResponseBody
    public String addArticle(Article article, HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        String userId = user.getId();
        String name = user.getName();
        String administrativeId = user.getAdministrativeId();
        article.setAdministrativeId(administrativeId);
        article.setPersonId(userId);
        article.setPersonName(name);
      //  articleService.save(article);
        return "success";
    }


}
