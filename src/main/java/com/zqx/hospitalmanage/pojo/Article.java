package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 */

@Entity
@Table(name = "Article")
public class Article implements Serializable {
  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "topic")
  private String topic;

  @Column(name = "content")
  private String content;

  @Column(name = "time")
  private Date time;

  @Column(name = "person_Id")
  private String personId;

  @Column(name = "person_Name")
  private String personName;

  @Column(name = "administrative_Id")
  private String administrativeId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }


  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }


  public String getAdministrativeId() {
    return administrativeId;
  }

  public void setAdministrativeId(String administrativeId) {
    this.administrativeId = administrativeId;
  }

  @Override
  public String toString() {
    return "Article{" +
            "id='" + id + '\'' +
            ", topic='" + topic + '\'' +
            ", content='" + content + '\'' +
            ", time=" + time +
            ", personId='" + personId + '\'' +
            ", personName='" + personName + '\'' +
            ", administrativeId='" + administrativeId + '\'' +
            '}';
  }
}
