package com.judge_group.judge.po;

import java.util.ArrayList;

public class Pred {
    private int id = 0;
    private String info;
    private String crime;
    private String term;
    private String time;
    private String tel;
    private ArrayList<String> predRule = new ArrayList<>();

    public Pred(int id, String info, String crime, String term, String time, String tel, ArrayList<String> predRule) {
        this.id = id;
        this.info = info;
        this.crime = crime;
        this.term = term;
        this.time = time;
        this.tel = tel;
        this.predRule = predRule;
    }

    public Pred() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public ArrayList<String> getPredRule() {
        return predRule;
    }

    public void setPredRule(ArrayList<String> predRule) {
        this.predRule = predRule;
    }
}