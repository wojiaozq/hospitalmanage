package com.zqx.hospitalmanage.pojo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Serializable {

  @Id
  private String id;
  private String name;
  private String remarks;

  @ManyToMany(fetch= FetchType.EAGER)
  @JoinTable(name = "role_menu",joinColumns = @JoinColumn(name = "role_id"),
          inverseJoinColumns = @JoinColumn(name = "menu_id"))
  private List<Menu> menu;

  public List<Menu> getMenu() {
    return menu;
  }

  public void setMenu(List<Menu> menu) {
    this.menu = menu;
  }

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

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  @Override
  public String toString() {
    return "Role{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", remarks='" + remarks + '\'' +
            ", menu=" + menu +
            '}';
  }
}
