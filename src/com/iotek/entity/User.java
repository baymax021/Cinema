package com.iotek.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class User implements Serializable{
    private int id;
    private String userName;
    private String userPassword;
    private String userPhone;
    private int userScore = 0;  //积分
    private Timestamp userCreateDate; //创建时间

    public User() {
    }

    public User(String userName, String userPassword, String userPhone) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public Timestamp getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Timestamp userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userScore=" + userScore +
                ", userCreateDate=" + userCreateDate +
                '}';
    }
}
