package com.zqx.hospitalmanage.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evlauate")
public class Evlauate {
  @Id
  /*@Column(name = "Id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)*/
  private String id;
  private String context;
  private String Commentator;
  private String timer;//发布时间
  private String doctorid;
  private String pid;
  private String doctorname;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getCommentator() {
    return Commentator;
  }

  public void setCommentator(String commentator) {
    Commentator = commentator;
  }

  public String getTimer() {
    return timer;
  }

  public void setTimer(String timer) {
    this.timer = timer;
  }

  public String getDoctorid() {
    return doctorid;
  }

  public void setDoctorid(String doctorid) {
    this.doctorid = doctorid;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getDoctorname() {
    return doctorname;
  }

  public void setDoctorname(String doctorname) {
    this.doctorname = doctorname;
  }
}
