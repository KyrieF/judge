package com.judge_group.judge.dao;

import com.judge_group.judge.po.User;

import java.util.ArrayList;

public interface IUserDao {
    public int addUser(User user);//1 means succeed,0 means error

    public int updateUser(User user);//1 means succeed,0 means error

    public User queryUser(String tel);

    public int deletUser(String tel);//1 means succeed,0 means error

    public ArrayList<User> getNearbyLawyer(User user);
}
