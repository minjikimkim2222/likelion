package org.example.jdbc01.RowMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DeptDao {
    private JdbcTemplate jdbcTemplate; // DeptDao에서 JdbcTemplate쓸거임..

    public DeptDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate; // 생성자 - 의존성 주입..
    }

    public List<Dept> getDepts(){
        RowMapper<Dept> rowMapper = new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                Dept dept = new Dept();
                dept.setId(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLocation(rs.getString("loc"));
                return dept;
            }
        };

        return jdbcTemplate.query("SELECT deptno,dname,loc FROM dept", rowMapper);
    }

}
