package cn.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

    @Id
    private int uid;
    private String uname;
    private String upass;

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return this.upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
