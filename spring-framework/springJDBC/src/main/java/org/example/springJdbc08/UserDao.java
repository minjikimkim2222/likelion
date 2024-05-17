package org.example.springJdbc08;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    // insert가 되면, 자동으로 생성된 PK(primary key)값을 리턴받고 싶어요..
    // SimpleJdbcInsert
    private SimpleJdbcInsert simpleJdbcInsert;
    // simpleJdbcInsert는 개발자가 몇가지 정보를 줘서 객체를 생성해주고 싶었어.. 원하는 시점에.. @PostConstruct
    @PostConstruct
    public void init(){
        // UserDao 객체가 만들어진 이후에야.. simpleJdbcInsert 생성하고싶음..
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
            // datasource, 실제 사용할 테이블명, 해당 테이블 PK에 해당하는 칼럼명.. , 이 3가지 정보를 주어야 simpleJdbcInsert 생성 !
    }

    public User insertUser(User user){
        // simpleJdbcInsert도 insert 구문은 딱히 안 만들어주니까.. Map으로 기본정보(key타입, Object)를 제공해줘야 함..
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName()); // params에 테이블 속성명 "name"에 값 넣어줄 것..
        params.put("email", user.getEmail());

        Number pk = simpleJdbcInsert.executeAndReturnKey(params); // users 테이블의 PK인 id를 Number형으로 리턴받음 !!
        user.setId(pk.longValue());
        return user;
    }
}
