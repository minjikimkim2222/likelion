package org.jwtExam.service;

import lombok.RequiredArgsConstructor;
import org.jwtExam.domain.RefreshToken;
import org.jwtExam.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public RefreshToken addRefreshToken(RefreshToken refreshToken){
        return refreshTokenRepository.save(refreshToken);
    }

    @Transactional(readOnly = true)
    public Optional<RefreshToken> findRefreshToken(String value){
        return refreshTokenRepository.findByValue(value);
    }
    @Transactional
    public void deleteRefreshToken(String value){
        refreshTokenRepository.findByValue(value).ifPresent(refreshTokenRepository::delete);
    }
}
