package com.judge_group.judge.servlet;

import com.judge_group.judge.dao.impl.UserDaoImpl;
import com.judge_group.judge.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("loginUser");
        UserDaoImpl dao = new UserDaoImpl();
        user.setNickname(request.getParameter("nickname"));
        user.setPassword(request.getParameter("password"));
        user.setAddress(request.getParameter("address"));
        user.setTel(request.getParameter("tel"));
        if (user.isStatus())
            user.setComname(request.getParameter("comname"));
        if (dao.updateUser(user) == 1) {
            //update succeed
        } else {
            //update faileds
        }
    }
}
