package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "Duty_Roster")

public class DutyRoster implements Serializable {
  @Id
  private String id;
  @Column(name = "start_Time")
  private Date startTime;
  @Column(name = "operation_Time")
  private Date operationTime;
  private String day01;
  private String day02;
  private String day03;
  private String day04;
  private String day05;
  private String day06;
  private String day07;
  private String day08;
  private String day09;
  private String day10;
  private String day11;
  private String day12;
  private String day13;
  private String day14;
  @Column(name = "doctor_Id")
  private String doctorId;
  @Column(name = "doctor_Name")
  private String doctorName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getOperationTime() {
    return operationTime;
  }

  public void setOperationTime(Date operationTime) {
    this.operationTime = operationTime;
  }

  public String getDay01() {
    return day01;
  }

  public void setDay01(String day01) {
    this.day01 = day01;
  }

  public String getDay02() {
    return day02;
  }

  public void setDay02(String day02) {
    this.day02 = day02;
  }

  public String getDay03() {
    return day03;
  }

  public void setDay03(String day03) {
    this.day03 = day03;
  }

  public String getDay04() {
    return day04;
  }

  public void setDay04(String day04) {
    this.day04 = day04;
  }

  public String getDay05() {
    return day05;
  }

  public void setDay05(String day05) {
    this.day05 = day05;
  }

  public String getDay06() {
    return day06;
  }

  public void setDay06(String day06) {
    this.day06 = day06;
  }

  public String getDay07() {
    return day07;
  }

  public void setDay07(String day07) {
    this.day07 = day07;
  }

  public String getDay08() {
    return day08;
  }

  public void setDay08(String day08) {
    this.day08 = day08;
  }

  public String getDay09() {
    return day09;
  }

  public void setDay09(String day09) {
    this.day09 = day09;
  }

  public String getDay10() {
    return day10;
  }

  public void setDay10(String day10) {
    this.day10 = day10;
  }

  public String getDay11() {
    return day11;
  }

  public void setDay11(String day11) {
    this.day11 = day11;
  }

  public String getDay12() {
    return day12;
  }

  public void setDay12(String day12) {
    this.day12 = day12;
  }

  public String getDay13() {
    return day13;
  }

  public void setDay13(String day13) {
    this.day13 = day13;
  }

  public String getDay14() {
    return day14;
  }

  public void setDay14(String day14) {
    this.day14 = day14;
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

  @Override
  public String toString() {
    return "DutyRoster{" +
            "id='" + id + '\'' +
            ", startTime=" + startTime +
            ", operationTime=" + operationTime +
            ", day01='" + day01 + '\'' +
            ", day02='" + day02 + '\'' +
            ", day03='" + day03 + '\'' +
            ", day04='" + day04 + '\'' +
            ", day05='" + day05 + '\'' +
            ", day06='" + day06 + '\'' +
            ", day07='" + day07 + '\'' +
            ", day08='" + day08 + '\'' +
            ", day09='" + day09 + '\'' +
            ", day10='" + day10 + '\'' +
            ", day11='" + day11 + '\'' +
            ", day12='" + day12 + '\'' +
            ", day13='" + day13 + '\'' +
            ", day14='" + day14 + '\'' +
            ", doctorId='" + doctorId + '\'' +
            ", doctorName='" + doctorName + '\'' +
            '}';
  }
}
