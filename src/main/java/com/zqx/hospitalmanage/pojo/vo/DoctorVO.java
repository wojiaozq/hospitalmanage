package com.zqx.hospitalmanage.pojo.vo;

import java.util.Date;

/**
 * @version 1.0
 * @program: hospitalmanage.DoctorVO
 * @description: Doctor的VO对象
 * @author:
 * @create: 2019-03-20 19:37:03
 **/

public class DoctorVO {

    private String id;
    private String name;
    private String job;
    private Date entryTime;
    private String sex;
    private String administrativeName;
    private String status;
    private String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdministrativeName() {
        return administrativeName;
    }

    public void setAdministrativeName(String administrativeName) {
        this.administrativeName = administrativeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
