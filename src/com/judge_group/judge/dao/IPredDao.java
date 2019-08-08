package com.judge_group.judge.dao;

import com.judge_group.judge.po.Pred;

import java.util.ArrayList;

public interface IPredDao {
    public int addPred(Pred pred);

    public int deletePred(int predid);

    public Pred queryPred(int predid);

    public ArrayList<Pred> queryMyPred(String userid);

    public ArrayList<Pred> querySimilarPred(Pred pred);
}
