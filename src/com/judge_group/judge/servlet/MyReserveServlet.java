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
import java.util.ArrayList;

@WebServlet(name = "MyReserveServlet")
public class MyReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("loginUser");
        ReserveDaoImpl dao = new ReserveDaoImpl();
        ArrayList<Reservation> myReserve = dao.queryMyReserve(user);
        if (myReserve != null) {
            //have reserve
            request.setAttribute("myReserve", myReserve);
            if (user.isStatus()) {
                //the lawyer reservation page
            } else {
                //the user reservation page
            }
        } else {
            //no reserve
        }
    }
}
