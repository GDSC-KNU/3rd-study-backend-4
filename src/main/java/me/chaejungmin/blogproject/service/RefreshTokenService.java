package me.chaejungmin.blogproject.service;

import lombok.RequiredArgsConstructor;
import me.chaejungmin.blogproject.domain.RefreshToken;
import me.chaejungmin.blogproject.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}

