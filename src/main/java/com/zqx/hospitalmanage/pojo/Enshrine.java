package com.zqx.hospitalmanage.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Enshrine")
public class Enshrine {//收藏
  @Id
  private String id;
  @Column(name = "doctor_Id")
  private String doctorId;
  @Column(name = "patient_Id")
  private String patientId;


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


  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

}
