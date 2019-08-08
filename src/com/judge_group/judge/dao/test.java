package com.judge_group.judge.dao;

import com.judge_group.judge.dao.impl.PredDaoImpl;
import com.judge_group.judge.po.Pred;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] as) {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String time = df.format(new Date());// new Date()为获取当前系统时间
//        System.out.println(time);

        PredDaoImpl predDao = new PredDaoImpl();
        Pred pred = new Pred();
        pred.setCrime("wwef");
        ArrayList<Pred> list = predDao.querySimilarPred(pred);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getPredRule().size(); j++)
                System.out.println("ID: " + list.get(i).getId() + " Info: " + list.get(i).getInfo() + " Crime: " + list.get(i).getCrime() + " Rule:" + list.get(i).getPredRule().get(j));
        }
    }
}
