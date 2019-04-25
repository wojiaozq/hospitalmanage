package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.Evlauate;

import javax.persistence.Id;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.EvlauateService
 * @description:
 * @author:
 * @create: 2019-03-26 14:16:46
 **/
public interface EvlauateService {

    public void add(Evlauate evlauate);

    public List<Evlauate> findallnull(String pid);

    public Evlauate findbyid(String id);

    public void update(Evlauate evlauate);

    public List<Evlauate> findallbyid(String doctorid);

    public int findcount(String doctorid);

    public List<Evlauate> finbypid(String pid);

    public void delbypid(String pid);

    public void delete(String id);
}
