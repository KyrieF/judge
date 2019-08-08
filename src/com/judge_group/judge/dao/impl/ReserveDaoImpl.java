package com.judge_group.judge.dao.impl;

import com.judge_group.judge.dao.IReserveDao;
import com.judge_group.judge.db.DB;
import com.judge_group.judge.po.*;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ReserveDaoImpl implements IReserveDao {
    String sql = "";

    @Override
    public int addReservation(Reservation reservation) {
        DB db = new DB();
        sql = "insert into reservation values(null,'" + reservation.getUserTel() + "','" + reservation.getLawyerTel() +
                "','" + reservation.getMakeTime() + "','" + reservation.getReserveTime() + "')";
        if (db.update(sql) == 1) {
            System.out.println("Reserve succeed!");
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteReservation(Reservation reservation) {
        DB db = new DB();
        sql = "delete from reservation where id = " + reservation.getId();
        if (db.update(sql) == 1) {
            System.out.println("Delete succeed!");
            return 1;
        }
        return 0;
    }

    @Override
    public int updateReservation(Reservation reservation) {
        DB db = new DB();
        sql = "update reservation set reservetime = '" + reservation.getReserveTime() + "' where id = " + reservation.getId();
        if (db.update(sql) == 1) {
            System.out.println("Delete succeed!");
            return 1;
        }
        return 0;
    }

    @Override
    public ArrayList<Reservation> queryMyReserve(User user) {
        ArrayList<Reservation> myReserve = new ArrayList<>();
        DB db = new DB();
        if (user.isStatus())
            sql = "select * from reservation,user where lawyertel = '" + user.getTel() + "' and user.tel ='" + user.getTel() + "'";
        else
            sql = "select * from reservation,user where usertel = '" + user.getTel() + "' and user.tel = reservation.lawyertel";
        ResultSet res = db.query(sql);
        if (res != null) {
            try {
                while (res.next()) {
                    Reservation reservation = new Reservation(res.getInt(1), res.getString(2),
                            res.getString(3), res.getString(4), res.getString(5), res.getString(9));
                    myReserve.add(reservation);
                }
                System.out.println("Query my reservation succeed");
                return myReserve;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
