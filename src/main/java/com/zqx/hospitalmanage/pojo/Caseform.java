package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Caseform")
public class Caseform implements Serializable {

  @Id
  private String id;
  private java.util.Date time;

  @Column(name = "diagnosis_Info")
  private String diagnosisInfo;

  @Column(name = "doctor_Id")
  private String doctorId;

  @Column(name = "patient_Id")
  private String patientId;

  @Column(name = "main_Suit")
  private String mainSuit;

  @Column(name = "present_Illness")
  private String presentIllness;
  @Column(name = "previous_History")
  private String previousHistory;

  private String result;

  @Column(name = "diagnose_Type")
  private String diagnoseType;

  @Column(name = "cure_Means")
  private String cureMeans;

  private String allergy;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getDiagnosisInfo() {
    return diagnosisInfo;
  }

  public void setDiagnosisInfo(String diagnosisInfo) {
    this.diagnosisInfo = diagnosisInfo;
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


  public String getMainSuit() {
    return mainSuit;
  }

  public void setMainSuit(String mainSuit) {
    this.mainSuit = mainSuit;
  }


  public String getPresentIllness() {
    return presentIllness;
  }

  public void setPresentIllness(String presentIllness) {
    this.presentIllness = presentIllness;
  }


  public String getPreviousHistory() {
    return previousHistory;
  }

  public void setPreviousHistory(String previousHistory) {
    this.previousHistory = previousHistory;
  }


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


  public String getDiagnoseType() {
    return diagnoseType;
  }

  public void setDiagnoseType(String diagnoseType) {
    this.diagnoseType = diagnoseType;
  }


  public String getCureMeans() {
    return cureMeans;
  }

  public void setCureMeans(String cureMeans) {
    this.cureMeans = cureMeans;
  }


  public String getAllergy() {
    return allergy;
  }

  public void setAllergy(String allergy) {
    this.allergy = allergy;
  }

}
