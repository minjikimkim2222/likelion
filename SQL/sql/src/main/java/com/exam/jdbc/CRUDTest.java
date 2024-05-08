package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 3. 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl = "jdbc:mysql://localhost:3307/exampleDB";
            String user = "minjiki2";
            String password = "minjiki1234";
            conn = DriverManager.getConnection(dburl, user, password);

            if (conn != null){
                System.out.println("접속 성공!");
            } else
                System.out.println("접속 실패!");

            // 4. 쿼리작성
                // insert
            String sql = "insert into dept(deptno,dname,loc) values (50, '개발부', '서울')";
                // update
            String updateSql = "update dept set dname = '디자인부' where dname = '개발부'";
                // delete
            String deleteSql = "delete from dept where dname = '디자인부'";

            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false); // 얘만 해주면, 커밋이 안되어 다른 세션에 50의 '개발부'가 들어가지 않았다..

            // 5. 실행
            int count = ps.executeUpdate();

            conn.commit(); // commit을 executeUpdate() 이후에 해줘야 올라간다!!
            System.out.println(count + "개수, insert/update/delete");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 2. 닫아준다.
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
