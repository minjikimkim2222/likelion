package org.jwtExam.jwt.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

/*
    AbstractAuthenticationToken 추상클래스를 상속해 구현한 JwtAuthenticationToken 클래스의 역할
        - 스프링 시큐리티에서 사용되는, 토큰기반인증방식 중 하나인, JWT (JSON Web Token)를 위한 커스텀인증토큰 정의하는 클래스

        주로 다음과 같은 역할
        1. 인증정보 저장 : JWT를 통해, 인증된 사용자의 인증정보 저장
        2. 인증상태 관리 : 인증성공여부 관리
        3. 사용자 정보 제공 : 인증된 사용자의 주체(principal)과 자격증명(credentials)를 제공
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private String token;
    private Object principal; // 로그인한 사용자 id, email
    private Object credentials;

    public JwtAuthenticationToken(Collection<? extends GrantedAuthority> authorities,
                                  Object principal, Object credentials){
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(true);
    }

    public JwtAuthenticationToken(String token){
        super(null);
        this.token = token;
        this.setAuthenticated(false);
    }

    // 자격증명 (credentials) 반환
    // -- JWT의 경우, 일반적으로 자격 증명을 별도로 사용되지 않기에 null 반환 가능
    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    // 주체(principal) 반환 -- 일반적으로 인증된 사용자 정보 반환되며, JWT의 페이로드에 포함된 사용자정보반환 가능
    @Override
    public Object getPrincipal() {
        return this.principal;
    }

}
