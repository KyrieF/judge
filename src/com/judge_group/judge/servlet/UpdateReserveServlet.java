package com.judge_group.judge.servlet;

import com.judge_group.judge.dao.impl.ReserveDaoImpl;
import com.judge_group.judge.po.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateReserveServlet")
public class UpdateReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Reservation reservation = new Reservation();
        ReserveDaoImpl dao = new ReserveDaoImpl();
        String time = request.getParameter("reserveTime");
        int id = Integer.parseInt(request.getParameter("reserveId"));
        reservation.setId(id);
        reservation.setReserveTime(time);
        if (dao.updateReservation(reservation) == 1) {
            //update succeed!
        } else {
            //update failed!
        }
    }
}
