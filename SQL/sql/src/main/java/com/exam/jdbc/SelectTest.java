package com.exam.jdbc;

import java.sql.*;

public class SelectTest {
    public static void main(String[] args) {
        // select는 insert/delete/update와 달리, 결과테이블이 ResultSet으로 추상화되어 있다!

        // 1. 생성 -> 생성과 동시에 닫는 코드를 finally에 써준다..
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String dburl = "jdbc:mysql://localhost:3307/exampleDB";
        String user = "minjiki2";
        String password = "minjiki1234";
        try {
            // 3. 접속
            conn = DriverManager.getConnection(dburl, user, password);

            // 4. 쿼리 작성
            String sql = "select deptno, dname, loc from dept";
            ps = conn.prepareStatement(sql);

            // 5. 쿼리 실행
            rs = ps.executeQuery(); // select는 지금까지와는 다르게 ResultSet을 리턴해주는 executeQuery..

            // 6. 결과를 얻어냄..
            while (rs.next() == true){
                System.out.print(rs.getInt("deptno") + ", ");
                System.out.print(rs.getString(2) + ", ");
                System.out.println(rs.getString("loc"));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally { // 2. 닫기
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
