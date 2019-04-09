package com.zqx.hospitalmanage.pojo.vo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class PatientreVo {
    private String name;
    private String Identification;
    private String sex;
    private String age;
    private String tel;
    private String address;
    private String timedetails;
    private String docoor_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mytime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return Identification;
    }

    public void setIdentification(String identification) {
        Identification = identification;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimedetails() {
        return timedetails;
    }

    public void setTimedetails(String timedetails) {
        this.timedetails = timedetails;
    }

    public String getDocoor_id() {
        return docoor_id;
    }

    public void setDocoor_id(String docoor_id) {
        this.docoor_id = docoor_id;
    }

    public Date getMytime() {
        return mytime;
    }

    @Override
    public String toString() {
        return "PatientreVo{" +
                "name='" + name + '\'' +
                ", Identification='" + Identification + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", timedetails='" + timedetails + '\'' +
                ", docoor_id='" + docoor_id + '\'' +
                ", mytime=" + mytime +
                '}';
    }

    public void setMytime(Date mytime) {
        this.mytime = mytime;
    }
}
