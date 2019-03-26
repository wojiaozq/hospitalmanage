package com.zqx.hospitalmanage.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evlauate")
public class Evlauate {
  @Id
  private String id;
  private String context;
  @Column(name = "case_id")
  private String caseId;

  @Column(name = "timer")
  private Date timer;//发布时间

  public Date getTimer() {
    return timer;
  }

  public void setTimer(Date timer) {
    this.timer = timer;
  }

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


  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

}
