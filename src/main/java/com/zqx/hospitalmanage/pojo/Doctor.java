package com.zqx.hospitalmanage.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="username")
    private String username;

    @Column(name="name")
    private String name;

    @Column(name="job")
    private String job;

    @Column(name = "entry_Time")
    private java.util.Date entryTime;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private java.util.Date birthday;

    @Column(name="patient_Num")
    private Integer patientNum;

    @Column(name="graduation_School")
    private String graduationSchool;

    @Column(name="administrative_Id")
    private String administrativeId;

    @Column(name="good_Project")
    private String goodProject;

    @Column(name="tel")
    private String tel;

    @Column(name="address")
    private String address;

    @Column(name="status")
    private String status;

    @Column(name="password")
    private String password;

    @Column(name="photo_Url")
    private String photoUrl;

    @Column(name="education")
    private String education;

//    @Transient
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "doctor_role",joinColumns = @JoinColumn(name = "doctor_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
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

    public String getJob() {
      return job;
    }

    public void setJob(String job) {
      this.job = job;
    }

    public Date getEntryTime() {
      return entryTime;
    }

    public void setEntryTime(Date entryTime) {
      this.entryTime = entryTime;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    public String getSex() {
      return sex;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }

    public Date getBirthday() {
      return birthday;
    }

    public void setBirthday(Date birthday) {
      this.birthday = birthday;
    }

    public Integer getPatientNum() {
      return patientNum;
    }

    public void setPatientNum(Integer patientNum) {
      this.patientNum = patientNum;
    }

    public String getGraduationSchool() {
      return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
      this.graduationSchool = graduationSchool;
    }

    public String getAdministrativeId() {
      return administrativeId;
    }

    public void setAdministrativeId(String administrativeId) {
      this.administrativeId = administrativeId;
    }

    public String getGoodProject() {
      return goodProject;
    }

    public void setGoodProject(String goodProject) {
      this.goodProject = goodProject;
    }

    public String getTel() {
      return tel;
    }

    public void setTel(String tel) {
      this.tel = tel;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getPhotoUrl() {
      return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
      this.photoUrl = photoUrl;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", entryTime=" + entryTime +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", patientNum=" + patientNum +
                ", graduationSchool='" + graduationSchool + '\'' +
                ", administrativeId='" + administrativeId + '\'' +
                ", goodProject='" + goodProject + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", education='" + education + '\'' +
                ", role=" + role +
                '}';
    }
}
