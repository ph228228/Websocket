package com.example.beans;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: penghao
 * @Date: 2017-12-26
 * @Time: 11:08
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String trueName;
    private Date hireDate;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", trueName='" + trueName + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
