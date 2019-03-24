package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Problem")
public class Problem {
  @Id
  private String id;
  private String head;
  private String context;
  private Date time;
  @Column(name = "quizzer_Id")
  private String quizzerId;
  @Column(name = "quizzer_Name")
  private String quizzerName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head;
  }


  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getQuizzerId() {
    return quizzerId;
  }

  public void setQuizzerId(String quizzerId) {
    this.quizzerId = quizzerId;
  }


  public String getQuizzerName() {
    return quizzerName;
  }

  public void setQuizzerName(String quizzerName) {
    this.quizzerName = quizzerName;
  }

}
