package com.judge_group.judge.po;

public class User {
    private String nickname;
    private String password;
    private String tel;//the name used to login
    private String address;
    private String comname;//the name of the lawyer's company,can be null
    private boolean status;//true means lawyer ,false means common user

    public User(String tel, String nickname, String password, String address, boolean status, String comname) {
        this.nickname = nickname;
        this.password = password;
        this.tel = tel;
        this.address = address;
        this.status = status;
        this.comname = comname;
    }

    public User(String tel, String nickname, String password, String address, boolean status) {
        this.nickname = nickname;
        this.password = password;
        this.tel = tel;
        this.address = address;
        this.status = status;
    }

    public User() {
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comName) {
        this.comname = comName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
