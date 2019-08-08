package com.judge_group.judge.dao.impl;

import com.judge_group.judge.dao.IPredDao;
import com.judge_group.judge.db.DB;
import com.judge_group.judge.po.Pred;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PredDaoImpl implements IPredDao {
    String sql = "";

    @Override
    public int addPred(Pred pred) {
        DB db = new DB();
        int flag = 0;
        sql = "insert into pred values(null,'" + pred.getInfo() + "','" + pred.getCrime() + "','" + pred.getTerm() +
                "','" + pred.getTime() + "','" + pred.getTel() + "')";
        if (db.update(sql) == 1)
            flag++;
        else
            flag--;
        for (int i = 0; i < pred.getPredRule().size(); i++) {
            sql = "insert into pred_rule values(" + pred.getId() + ",'" + pred.getPredRule().get(i) + "')";
            if (db.update(sql) == 1)
                flag++;
            else
                flag--;
        }
        return flag - pred.getPredRule().size();
    }

    @Override
    public int deletePred(int predid) {
        DB db = new DB();
        int flag = 0;
        sql = "delete from pred where predid = " + predid;
        if (db.update(sql) == 1)
            flag++;
        else
            flag--;
        sql = "delete from pred_rule where predid = " + predid;
        if (db.update(sql) == 1)
            flag++;
        else
            flag--;
        return flag - 1;
    }

    @Override
    public Pred queryPred(int predid) {
        DB db = new DB();
        Pred pred = new Pred();
        ArrayList<String> pred_rule = new ArrayList<>();
        sql = "select * from pred natural join pred_rule where predid = " + predid;
        ResultSet res = db.query(sql);
        if (res != null) {
            try {
                while (res.next()) {
                    pred.setId(res.getInt(1));
                    pred.setInfo(res.getString(2));
                    pred.setCrime(res.getString(3));
                    pred.setTerm(res.getString(4));
                    pred.setTime(res.getString(5));
                    pred.setTel(res.getString(6));
                    pred_rule.add(res.getString(7));
                }
                pred.setPredRule(pred_rule);
                return pred;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Pred> queryMyPred(String tel) {
        DB db = new DB();
        sql = "select * from pred natural join pred_rule where tel = '" + tel + "'";
        ResultSet res = db.query(sql);
        if (res != null) {
            try {
                Pred pred = new Pred();
                ArrayList<Pred> myPred = new ArrayList<>();
                myPred.add(pred);
                int predid;
                String info;
                String crime;
                String term;
                String time;
                String pred_tel;
                String one_rule;
                while (res.next()) {
                    predid = res.getInt(1);
                    info = res.getString(2);
                    crime = res.getString(3);
                    term = res.getString(4);
                    time = res.getString(5);
                    pred_tel = res.getString(6);
                    one_rule = res.getString(7);
                    if (myPred.get(myPred.size() - 1).getId() == predid || myPred.get(myPred.size() - 1).getId() == 0) {
                        myPred.get(myPred.size() - 1).setId(predid);
                        myPred.get(myPred.size() - 1).setInfo(info);
                        myPred.get(myPred.size() - 1).setCrime(crime);
                        myPred.get(myPred.size() - 1).setTerm(term);
                        myPred.get(myPred.size() - 1).setTime(time);
                        myPred.get(myPred.size() - 1).setTel(pred_tel);
                        myPred.get(myPred.size() - 1).getPredRule().add(one_rule);
                    } else {
                        myPred.add(new Pred());
                        myPred.get(myPred.size() - 1).setId(predid);
                        myPred.get(myPred.size() - 1).setInfo(info);
                        myPred.get(myPred.size() - 1).setCrime(crime);
                        myPred.get(myPred.size() - 1).setTerm(term);
                        myPred.get(myPred.size() - 1).setTime(time);
                        myPred.get(myPred.size() - 1).setTel(pred_tel);
                        myPred.get(myPred.size() - 1).getPredRule().add(one_rule);
                    }
                }
                return myPred;
            } catch (
                    Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Pred> querySimilarPred(Pred p) {
        DB db = new DB();
        sql = "select * from pred natural join pred_rule where predcrime like '%" + p.getCrime() + "%'";
        ResultSet res = db.query(sql);
        if (res != null) {
            try {
                Pred pred = new Pred();
                ArrayList<Pred> myPred = new ArrayList<>();
                myPred.add(pred);
                int predid;
                String info;
                String crime;
                String term;
                String time;
                String pred_tel;
                String one_rule;
                while (res.next()) {
                    predid = res.getInt(1);
                    info = res.getString(2);
                    crime = res.getString(3);
                    term = res.getString(4);
                    time = res.getString(5);
                    pred_tel = res.getString(6);
                    one_rule = res.getString(7);
                    if (myPred.get(myPred.size() - 1).getId() == predid || myPred.get(myPred.size() - 1).getId() == 0) {
                        myPred.get(myPred.size() - 1).setId(predid);
                        myPred.get(myPred.size() - 1).setInfo(info);
                        myPred.get(myPred.size() - 1).setCrime(crime);
                        myPred.get(myPred.size() - 1).setTerm(term);
                        myPred.get(myPred.size() - 1).setTime(time);
                        myPred.get(myPred.size() - 1).setTel(pred_tel);
                        myPred.get(myPred.size() - 1).getPredRule().add(one_rule);
                    } else {
                        myPred.add(new Pred());
                        myPred.get(myPred.size() - 1).setId(predid);
                        myPred.get(myPred.size() - 1).setInfo(info);
                        myPred.get(myPred.size() - 1).setCrime(crime);
                        myPred.get(myPred.size() - 1).setTerm(term);
                        myPred.get(myPred.size() - 1).setTime(time);
                        myPred.get(myPred.size() - 1).setTel(pred_tel);
                        myPred.get(myPred.size() - 1).getPredRule().add(one_rule);
                    }
                }
                return myPred;
            } catch (
                    Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
