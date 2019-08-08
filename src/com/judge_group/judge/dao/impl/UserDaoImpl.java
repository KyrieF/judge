package com.judge_group.judge.dao.impl;

import com.judge_group.judge.dao.IUserDao;
import com.judge_group.judge.db.DB;
import com.judge_group.judge.po.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements IUserDao {
    String sql = "";

    @Override
    public int addUser(User user) {
        DB db = new DB();
        if (user.isStatus()) {
            System.out.println("Lawyer sign up");
            sql = "insert into user values('" + user.getTel() + "','" + user.getNickname() + "','" + user.getPassword() + "" +
                    "','" + user.getAddress() + "'," + user.isStatus() + ",'" + user.getComname() + "')";
        } else {
            System.out.println("Common user sign up");
            sql = "insert into user values('" + user.getTel() + "','" + user.getNickname() + "','" + user.getPassword() + "" +
                    "','" + user.getAddress() + "'," + user.isStatus() + ",null)";
        }
        if (db.update(sql) == 1) {
            System.out.println("Add user succeed!");
            return 1;
        }
        System.out.println("Add user error!");
        return 0;
    }

    @Override
    public int updateUser(User user) {
        DB db = new DB();
        if (user.isStatus())
            sql = "update user set nickname = '" + user.getNickname() + "',password = '" +
                    user.getPassword() + "',address = '" + user.getAddress() + "' where tel = '" + user.getTel() + "',comname = '" + user.getComname() + "';";
        else
            sql = "update user set nickname = '" + user.getNickname() + "',password = '" +
                    user.getPassword() + "',address = '" + user.getAddress() + "' where tel = '" + user.getTel() + "';";
        if (db.update(sql) == 1) {
            System.out.println("Update user succeed!");
            return 1;
        }
        System.out.println("Update user error!");
        return 0;
    }

    @Override
    public User queryUser(String tel) {
        DB db = new DB();
        sql = "select * from user where tel = '" + tel + "';";
        ResultSet res = db.query(sql);
        if (res != null) {
            try {
                res.next();
                if (res.getBoolean(6))
                    return new User(res.getString(1), res.getString(2), res.getString(3),
                            res.getString(4), res.getBoolean(5), res.getString(6));
                else
                    return new User(res.getString(1), res.getString(2), res.getString(3),
                            res.getString(4), res.getBoolean(5));
            } catch (SQLException e) {
                System.out.println("Query user error!");
                return null;
            }

        }
        return null;
    }

    public int deletUser(String tel) {
        DB db = new DB();
        sql = "delete from user where tel = '" + tel + "';";
        if (db.update(sql) == 1) {
            System.out.println("Delete user succeed!");
            return 1;
        }
        return 0;
    }

    public ArrayList<User> getNearbyLawyer(User user) {
        ArrayList<User> list = new ArrayList<>();
        DB db = new DB();
        sql = "select * from user where comname like '%" + user.getAddress() + "%' and status = true";
        ResultSet res = db.query(sql);
        if (res != null) {
            try {
                while (res.next()) {
                    list.add(new User(res.getString(1), res.getString(2), res.getString(3),
                            res.getString(4), true, res.getString(6)));
                }
                return list;
            } catch (Exception e) {
                System.out.println("getNearbyLawyer error!");
                return null;
            }
        }
        return null;
    }
}
