package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTest {
    public static void main(String[] args) {
        String dburl = "jdbc:mysql://localhost:3307/exampleDB";
        String user = "minjiki2";
        String password = "minjiki1234";

        String dname = "인사부";
        int deptno = 40;
        // 드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "update dept set dname = ? where deptno = ?";

        try (Connection conn = DriverManager.getConnection(dburl, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // ?에 대한 값을 채워준다.
            ps.setString(1, dname);
            ps.setInt(2, deptno);

            int count = ps.executeUpdate();
            System.out.println(count + "건 수정했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
