package com.iotek.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Admin implements Serializable {
    private int id;
    private String adminName;
    private String adminPassword;
    private String adminStatus ;  // 状态 （可用  或者  不可用）
    private Timestamp adminLoginDate;  // 最后登录时间

    public Admin() {
    }

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public Timestamp getAdminLoginDate() {
        return adminLoginDate;
    }

    public void setAdminLoginDate(Timestamp adminLoginDate) {
        this.adminLoginDate = adminLoginDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminStatus=" + adminStatus +
                ", adminLoginDate=" + adminLoginDate +
                '}';
    }
}
