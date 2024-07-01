package org.jwtExam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDto {
    private String accessToken; // 로그인 성공시, 발급된 엑세스 토큰
    private String refreshToken; // 로그인 성공시, 발급된 리프레시 토큰
    private Long userId;
    private String name;
}
