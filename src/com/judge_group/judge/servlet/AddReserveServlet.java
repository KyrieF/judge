package com.judge_group.judge.servlet;

import com.judge_group.judge.dao.impl.ReserveDaoImpl;
import com.judge_group.judge.po.Reservation;
import com.judge_group.judge.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddReserveServlet")
public class AddReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("user");
        String lawyerTel = request.getParameter("lawyerTel");
        String reserveTime = request.getParameter("time");
        Reservation reservation = new Reservation();
        reservation.setLawyerTel(lawyerTel);
        reservation.setReserveTime(reserveTime);
        reservation.setUserTel(user.getTel());
        reservation.setMakeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ReserveDaoImpl dao = new ReserveDaoImpl();
        if (dao.addReservation(reservation) == 1) {
            //Add succeed!
        } else {
            //Add failed!
        }
    }
}
