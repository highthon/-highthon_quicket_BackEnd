package com.example.dokgodieserver.domain.user.service;

import com.example.dokgodieserver.domain.user.domain.User;
import com.example.dokgodieserver.domain.user.domain.repository.UserRepository;
import com.example.dokgodieserver.domain.user.exception.PasswordMisMatchException;
import com.example.dokgodieserver.domain.user.exception.UserNotFoundException;
import com.example.dokgodieserver.domain.user.presentation.dto.request.SignInRequest;
import com.example.dokgodieserver.domain.user.presentation.dto.response.TokenResponse;
import com.example.dokgodieserver.global.security.jwt.JwtProperties;
import com.example.dokgodieserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse execute(SignInRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateToken(request.getAccountId(),jwtProperties.getAccessExp());

        return new TokenResponse(accessToken, LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()));
    }

}
