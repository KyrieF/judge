package com.judge_group.judge.dao;

import com.judge_group.judge.po.*;

import java.util.ArrayList;

public interface IReserveDao {
    public int addReservation(Reservation reservation);

    public int deleteReservation(Reservation reservation);

    public int updateReservation(Reservation reservation);

    public ArrayList<Reservation> queryMyReserve(User user);
}
