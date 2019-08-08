package com.judge_group.judge.servlet;

import com.judge_group.judge.dao.impl.PredDaoImpl;
import com.judge_group.judge.po.Pred;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuerySimilarPredictServlet")
public class QuerySimilarPredictServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Pred pred = new Pred();
        String crime = request.getParameter("predCrime");
        pred.setCrime(crime);
        PredDaoImpl dao = new PredDaoImpl();
        ArrayList<Pred> similarPred = dao.querySimilarPred(pred);
        if (similarPred != null) {
            request.setAttribute("similarPred", similarPred);
            //have similar pred
        } else {
            //no similar pred
        }
    }
}
