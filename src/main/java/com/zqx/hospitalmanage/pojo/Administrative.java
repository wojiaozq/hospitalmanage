package com.zqx.hospitalmanage.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Administrative")
public class Administrative implements Serializable {

    @Id
    private String id;
    private String name;
    private String type;
    private String remaker;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemaker() {
        return remaker;
    }

    public void setRemaker(String remaker) {
        this.remaker = remaker;
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

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }
}
