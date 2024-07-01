package org.jwtExam;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.jwtExam.jwt.util.JwtTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class JWTexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWTexamApplication.class, args);
    }

    @Autowired
    JwtTokenizer jwtTokenizer;

   // @Bean
    public CommandLineRunner run(){
        return args -> {
            String accessToken = jwtTokenizer.createAccessToken(
                    1L, "test@test.com", "test", "testUser",
                    Arrays.asList("ROLE_USER", "ROLE_ADMIN")
            );

            log.info("Access Token : {}", accessToken);

            String refreshToken = jwtTokenizer.createRefreshToken(
                    2L, "refresh@email.com", "refresh", "refreshUser",
                    Arrays.asList("ROLE_USER")
            );

            log.info("refresh Token : {}", refreshToken);

            Long userIdFromAccessToken = jwtTokenizer.getUserIdFromToken(accessToken);
            log.info("userIdFromAccessToken : {}", userIdFromAccessToken);

            Claims claimsAccessToken = jwtTokenizer.parseAccessToken(accessToken);
            log.info("claimsAccessToken : {}", claimsAccessToken);

            Claims claimsRefreshToken = jwtTokenizer.parseRefreshToken(refreshToken);
            log.info("claimAccessToken.getRole : {}", claimsRefreshToken.get("roles"));
        };
    }
}
