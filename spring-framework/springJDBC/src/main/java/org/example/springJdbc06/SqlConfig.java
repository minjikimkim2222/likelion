package org.example.springJdbc06;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class SqlConfig {
//    @Bean -- NamedParameterJdbcTemplate을 이미 spring starter에서 빈으로 등록했을 것 같아.. 주석 처리 !
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) { // 프로젝트 설정할 때, application.xml에 설정했음..!
//        return new NamedParameterJdbcTemplate(dataSource);
//    }

    @Bean // Spring에서 외부 SQL 파일을 로드하기 위해 Resource 객체 사용..
    public Properties sqlQueries() throws IOException {
        Resource resource = new ClassPathResource("sql/queries.sql"); // ~/resources 폴더 하위 경로 쓰면 됨..

        Properties properties = new Properties();
        properties.load(resource.getInputStream());

        return properties;
    }
}