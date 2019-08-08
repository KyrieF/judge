package com.judge_group.judge.db;

import java.sql.*;

public class DB {
    private Connection conn;

    //在构造方法中，完成连接
    public DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3307/judge?serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
            this.conn = DriverManager.getConnection(url, "root", "kyrie");
            System.out.println("yes");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("mysql connection failed");
            e.printStackTrace();
        }
    }

    //执行增删改
    public int update(String sql) {
        System.out.println("sql: " + sql);
        try {
            Statement stmt = (Statement) this.conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    //执行查询
    public ResultSet query(String sql) {
        System.out.println("sql: " + sql);
        try {
            Statement stmt = (Statement) this.conn.createStatement();
            return ((Statement) stmt).executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getGenerateId(String sql) {
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return this.conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error when executing getPreparedStatement in DB class");
        }
        return null;
    }

}


