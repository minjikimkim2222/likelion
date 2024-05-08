package com.exam.jdbc;

import java.sql.*;
import java.sql.DriverManager;

// DBUtil 클래스는 각 인스턴스마다 저장해줘야하는 값이 없으므로 static으로 만들어주면,
// 굳이 이 Util 클래스를 쓰자고 DeptDAO에서 객체를 생성할 필요가 없다..
public class DBUtil {
    // DB 접속
    public static Connection getConnection() throws Exception{
        Connection conn = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3307/exampledb";
        String user = "minjiki2";
        String password = "minjiki1234";
        conn = DriverManager.getConnection(dbUrl,user,password);

        return conn;
    }

    public static Connection getConnection(String dbUrl, String user, String password){
        Connection conn = null;

        return conn;
    }

    // DB close
    public static void close(Connection conn) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
