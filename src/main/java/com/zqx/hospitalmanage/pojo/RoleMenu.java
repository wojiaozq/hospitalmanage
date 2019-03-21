package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Role_Menu")
public class RoleMenu implements Serializable  {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "role_Id")
  private String roleId;

  @Column(name = "menu_Id")
  private String menuId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

}
