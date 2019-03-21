package com.zqx.hospitalmanage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Solve_Docker")
public class SolveDocker {
  @Id
  private String id;
  @Column(name = "problem_Id")
  private String problemId;
  @Column(name = "docker_Id")
  private String dockerId;
  @Column(name = "docker_Name")
  private String dockerName;


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


  public String getDockerId() {
    return dockerId;
  }

  public void setDockerId(String dockerId) {
    this.dockerId = dockerId;
  }


  public String getDockerName() {
    return dockerName;
  }

  public void setDockerName(String dockerName) {
    this.dockerName = dockerName;
  }

}
