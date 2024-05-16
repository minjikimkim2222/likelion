package org.example.springJdbc03;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
@RequiredArgsConstructor // jdbcTemplate, transactionTemplate 생성자 주입..
@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;

    public void executeComplexBusinessProcess(String name, String email){
        transactionTemplate.execute( status -> {
            jdbcTemplate.update("insert into users (name,email) values (?,?)",name,email);

            if (email.contains("error")){ // 일부로 에러 발생..
                status.setRollbackOnly(); // 개발자가 직접 롤백 시키기..
                throw new RuntimeException("Simulated error to trigger rollback...");
            }

            jdbcTemplate.update("update users set email = ? where name = ?", "updated.email@example.com", name);
            return null;
        });
    }
}
