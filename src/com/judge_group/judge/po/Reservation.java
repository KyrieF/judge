package com.judge_group.judge.po;

public class Reservation {
    private int id;
    private String userTel;
    private String lawyerTel;
    private String makeTime;
    private String reserveTime;
    private String address;

    public Reservation() {
    }

    public Reservation(int id, String userTel, String lawyerTel, String makeTime, String reserveTime, String address) {
        this.id = id;
        this.userTel = userTel;
        this.lawyerTel = lawyerTel;
        this.makeTime = makeTime;
        this.reserveTime = reserveTime;
        this.address = address;
    }

    public String getUserTel() {
        return userTel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getLawyerTel() {
        return lawyerTel;
    }

    public void setLawyerTel(String lawyerTel) {
        this.lawyerTel = lawyerTel;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }
}
