package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Torder")
public class Torder {
  @Id
  private String id;
  @Column(name = "appointment_Time")
  private Date appointmentTime;

  @Column(name = "doctor_Id")
  private String doctorId;

  @Column(name = "doctor_Name")
  private String doctorName;
  private double money;

  @Column(name = "pay_Time")
  private Date payTime;

  @Column(name = "registration_Id")
  private String registrationId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(Date appointmentTime) {
    this.appointmentTime = appointmentTime;
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

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }
}
