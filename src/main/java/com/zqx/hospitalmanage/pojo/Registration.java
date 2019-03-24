package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Registration")
public class Registration {
  @Id
  private String id;

  @Column(name = "administrative_Id")
  private String administrativeId;

  @Column(name = "administrative_Name")
  private String administrativeName;

  @Column(name = "doctor_Id")
  private String doctorId;

  @Column(name = "doctor_Name")
  private String doctorName;

  @Column(name = "patient_Id")
  private String patientId;

  @Column(name = "patient_Name")
  private String patientName;

  @Column(name = "booking_Period")
  private Date bookingPeriod;

  private long no;
  private long status;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getAdministrativeId() {
    return administrativeId;
  }

  public void setAdministrativeId(String administrativeId) {
    this.administrativeId = administrativeId;
  }


  public String getAdministrativeName() {
    return administrativeName;
  }

  public void setAdministrativeName(String administrativeName) {
    this.administrativeName = administrativeName;
  }


  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
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


  public Date getBookingPeriod() {
    return bookingPeriod;
  }

  public void setBookingPeriod(Date bookingPeriod) {
    this.bookingPeriod = bookingPeriod;
  }


  public long getNo() {
    return no;
  }

  public void setNo(long no) {
    this.no = no;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
