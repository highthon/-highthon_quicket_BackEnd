package com.example.dokgodieserver.domain.grade.service;

import com.example.dokgodieserver.domain.user.domain.User;
import com.example.dokgodieserver.domain.user.domain.repository.UserRepository;
import com.example.dokgodieserver.domain.user.exception.UserNotFoundException;
import com.example.dokgodieserver.domain.user.presentation.dto.request.GradeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GradeService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(Long targetId, GradeRequest request) {

        User targetUser = userRepository.findById(targetId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        int result = targetUser.getResult() + request.getGrade();
        targetUser.setResult(result);
    }

}
