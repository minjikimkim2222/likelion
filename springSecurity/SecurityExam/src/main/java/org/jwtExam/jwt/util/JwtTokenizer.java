package org.jwtExam.jwt.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtTokenizer {
    private final byte[] accessSecret;
    // Access Token을 서명하는데 사용되는 비밀키 (JWT의 Signature에서, Access Token의 서명을 생성해, 검증하는데 사용됨)
    // 사용자의 인증을 빠르고 간편하게 하기 위해, 서버가 클라이언트에 발급하는 토큰. 유지기간이 짧음
    private final byte[] refreshSecret;
    // Refresh Token을 서명하는데 사용되는 비밀키
    // Access Token이 만료되었을 때, 새로운 Access Token을 발급받기 위해 사용되는 토큰
    // 클라이언트가 만료된 Access Token을 서버에 보내면, 서버는 Refresh Token을 확인해, 새로운 Access Token을 발급함.
    // 보다 더 긴 유효기간.

    public static Long ACCESS_TOKEN_EXPIRE_COUNT = 1 * 60 * 1000L; // 30분 -- accessToken 유지시간

    public static Long REFRESH_TOKEN_EXPIRE_COUNT =  7 * 24 * 60 * 60 * 1000L; // 7 days

    public JwtTokenizer(@Value("${jwt.secretKey}") String accessSecret,
                        @Value("${jwt.refreshKey}") String refreshSecret){
        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);
    }

    // JWT 토큰 생성
    private String createToken(Long id, String email, String name, String username, List<String> roles,
                               Long expire, byte[] secretKey) {
        // JWT 클레임을 생성하고, 주제를 email로 설정
        // -- 클레임의 주제(subject) : 토큰의 주요 식별자 역할, 이메일을 통해 사용자를 고유하게 식별해줌
        Claims claims = Jwts.claims().setSubject(email);

        // 클레임에 사용자 정보 넣기
        claims.put("roles", roles);
        claims.put("userId", id);
        claims.put("name", name);
        claims.put("username", username);

        // JWT 빌더를 이용해, 토큰 생성
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date()) // 현재 시간
                .setExpiration(new Date(new Date().getTime() + expire)) // 만료시간 설정
                .signWith(getSigningKey(secretKey)) // 서명 설정
                .compact(); // JWT 문자열로 압축
    }

    public static Key getSigningKey(byte[] secretKey){
        return Keys.hmacShaKeyFor(secretKey);
    }

    // Access Token 생성
    public String createAccessToken(Long id, String email, String name, String username, List<String> roles){
        return createToken(id, email, name, username, roles, ACCESS_TOKEN_EXPIRE_COUNT, accessSecret);
    }

    // RefreshToken 생성
    public String createRefreshToken(Long id, String email, String name, String username, List<String> roles){
        return createToken(id, email, name, username, roles, REFRESH_TOKEN_EXPIRE_COUNT, refreshSecret);
    }

    // 토큰에서, 유저 아이디 얻기
    public Long getUserIdFromToken(String token){
        String[] tokenArr = token.split(" ");

        if (tokenArr.length >= 2) {
            token = tokenArr[1];
        }
       // token = tokenArr[1];
        Claims claims = parseToken(token, accessSecret); // 토큰을 파싱해서 Claims 객체부분 얻어내기
        return Long.valueOf((Integer)claims.get("userId")); // 클레임에서 userId를 추출해, Long타입으로 변환후 반환
    }

    public Claims parseToken(String token, byte[] secretKey){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Access Token을 파싱하여 Claims 객체 반환
    public Claims parseAccessToken(String accessToken) {
        return parseToken(accessToken, accessSecret);
    }

    // Refresh Token을 파싱하여 Claims 객체 반환
    public Claims parseRefreshToken(String refreshToken) {
        return parseToken(refreshToken, refreshSecret);
    }
}
