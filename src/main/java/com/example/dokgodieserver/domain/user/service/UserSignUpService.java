package com.example.dokgodieserver.domain.user.service;

import com.example.dokgodieserver.domain.user.domain.User;
import com.example.dokgodieserver.domain.user.domain.repository.UserRepository;
import com.example.dokgodieserver.domain.user.domain.type.Authority;
import com.example.dokgodieserver.domain.user.exception.UserAlreadyExistsException;
import com.example.dokgodieserver.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(SignUpRequest request) {

        if(userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .authority(Authority.USER)
                .result(0)
                .build());
    }

}
