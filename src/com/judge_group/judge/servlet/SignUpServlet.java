package com.judge_group.judge.servlet;

import com.judge_group.judge.dao.impl.UserDaoImpl;
import com.judge_group.judge.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user;
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        if (status) {
            System.out.println("Lawyer sign up request");
            user = new User(request.getParameter("tel"), request.getParameter("nickname"), request.getParameter("password"),
                    request.getParameter("address"), status, request.getParameter("comname"));
        } else {
            System.out.println("User sign up request");
            user = new User(request.getParameter("tel"), request.getParameter("nickname"), request.getParameter("password"),
                    request.getParameter("address"), status);
        }
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.addUser(user) == 1) {
            //succeed,go to the next jsp page
            response.sendRedirect("");
        } else {
            //failed,stay at the current jsp page
            response.sendRedirect("");
        }
    }
}
