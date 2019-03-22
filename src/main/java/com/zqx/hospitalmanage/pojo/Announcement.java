package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/*
 * 公告
 */
@Entity
@Table(name = "Announcement")
public class Announcement implements Serializable {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "release_Time")
  private Date releaseTime;//发布时间

  @Column(name = "topic")
  private String topic;

  @Column(name = "content")
  private String content;

  @Column(name = "person_Id")
  private String personId;

  @Column(name = "person_Name")
  private String personName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getReleaseTime() {
    return releaseTime;
  }

  public void setReleaseTime(Date releaseTime) {
    this.releaseTime = releaseTime;
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

}
