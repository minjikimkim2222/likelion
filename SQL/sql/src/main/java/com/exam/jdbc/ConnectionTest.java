package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        // 1. 드라이버 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dburl = "jdbc:mysql://localhost:3307/exampleDB";
        String user = "minjiki2";
        String password = "minjiki1234";

        // 2. 접속 객체 얻어오기
        Connection conn = DriverManager.getConnection(dburl, user, password);

        if (conn != null){
            System.out.println("접속 성공!");
        } else
            System.out.println("접속 실패!");


        String dname = "개발부";
        String sql = "insert into dept (deptno, dname) values (3, '" +dname+"')";

        // dbms는 쿼리가 들어오면 번역한다. 이때 같은 쿼리가 들어오면 이미 번역된 것을 이용한다..
        // 값이 바뀌어도 다른 쿼리로 인식한다. 즉, 매번 번역한다..

        // 하지만, PreparedStatement는 효율성을 위해 값이 바뀌는 부분만 ? 처리하고, 나머지는 전처리해준다..
        String sql2 = "insert into dept (deptno, dname) values (3, ?)";
        // 여기까지를 번역.
        // 값이 나중에 바뀌므로, 매번 번역하지 않는다.. 문자열도 간결해지고.. 성능도 좋으므로..
    }
}
