package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Registration")
public class Registration {
  @Id
  private String id;

  @Column(name = "administrative_Name")
  private String administrativeName;

  @Column(name = "doctor_Name")
  private String doctorName;

  @Column(name = "patient_Id")
  private String patientId;

  @Column(name = "patient_Name")
  private String patientName;

  @Column(name = "doctor_id")
  private String doctorid;

  private String Identification;
  private String timedetails;
  private String cost;
  private Date mytime;
  private String status;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAdministrativeName() {
    return administrativeName;
  }

  public void setAdministrativeName(String administrativeName) {
    this.administrativeName = administrativeName;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
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

  public String getDoctorid() {
    return doctorid;
  }

  public void setDoctorid(String doctorid) {
    this.doctorid = doctorid;
  }

  public String getIdentification() {
    return Identification;
  }

  public void setIdentification(String identification) {
    Identification = identification;
  }

  public String getTimedetails() {
    return timedetails;
  }

  public void setTimedetails(String timedetails) {
    this.timedetails = timedetails;
  }

  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public Date getMytime() {
    return mytime;
  }

  public void setMytime(Date mytime) {
    this.mytime = mytime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
