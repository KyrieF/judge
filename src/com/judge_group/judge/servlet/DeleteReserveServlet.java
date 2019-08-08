package com.judge_group.judge.servlet;

import com.judge_group.judge.dao.impl.ReserveDaoImpl;
import com.judge_group.judge.po.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReserveServlet")
public class DeleteReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        ReserveDaoImpl dao = new ReserveDaoImpl();
        int deleteObject = Integer.parseInt(request.getParameter("reserveId"));
        Reservation reservation = new Reservation();
        reservation.setId(deleteObject);
        if (dao.deleteReservation(reservation) == 1) {
            //Delete succeed
        } else {
            //Delete failed
        }
    }
}
