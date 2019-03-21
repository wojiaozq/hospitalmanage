package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Solve_Patient")
public class SolvePatient {
  @Id
  private String id;
  @Column(name = "problem_Id")
  private String problemId;
  @Column(name = "patient_Id")
  private String patientId;
  @Column(name = "patient_Name")
  private String patientName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getProblemId() {
    return problemId;
  }

  public void setProblemId(String problemId) {
    this.problemId = problemId;
  }


  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }


  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

}
