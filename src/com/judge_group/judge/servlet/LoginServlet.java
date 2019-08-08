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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String tel = "";
        String password = "";
        tel = request.getParameter("tel");
        password = request.getParameter("password");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryUser(tel);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession sess = request.getSession();
            sess.setAttribute("loginUser", user);
            if (user.isStatus())
                //succeed,go to the lawyer jsp
                response.sendRedirect("");
            else
                //go to the User jsp
                response.sendRedirect("");
        } else {
            //failed,stay at the current jsp page
            response.sendRedirect("");
        }
    }
}
