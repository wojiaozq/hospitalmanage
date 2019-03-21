package com.zqx.hospitalmanage.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

  @Id
  private String id;
  private String url;
  private String name;
  private String pid;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  @Override
  public String toString() {
    return "Menu{" +
            "id='" + id + '\'' +
            ", url='" + url + '\'' +
            ", name='" + name + '\'' +
            ", pid='" + pid + '\'' +
            '}';
  }
}
