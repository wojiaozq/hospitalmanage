package com.zqx.hospitalmanage.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Doctor_Role")
public class DoctorRole implements Serializable {
  @Id
  private String id;

  @Column(name="doctor_Id")
  private String  doctorId; // 用户

  @Column(name="role_Id")
  private String  roleId; // 角色

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }
}
