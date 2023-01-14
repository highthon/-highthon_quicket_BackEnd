package com.example.dokgodieserver.domain.user.presentation;

import com.example.dokgodieserver.domain.grade.service.GradeService;
import com.example.dokgodieserver.domain.user.presentation.dto.request.GradeRequest;
import com.example.dokgodieserver.domain.user.presentation.dto.request.SignInRequest;
import com.example.dokgodieserver.domain.user.presentation.dto.request.SignUpRequest;
import com.example.dokgodieserver.domain.conversation.presentation.dto.ConversationResponse;
import com.example.dokgodieserver.domain.user.presentation.dto.response.MyPageResponse;
import com.example.dokgodieserver.domain.user.presentation.dto.response.TokenResponse;
import com.example.dokgodieserver.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    private final MyPageService myPageService;
    private final GradeService gradeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userSignUpService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return userSignInService.execute(request);
    }

    @GetMapping("/my-page")
    public MyPageResponse getMyPage() {
        return myPageService.execute();
    }

    @PutMapping("/grade/{user-id}")
    public void grade(@PathVariable("user-id") Long userId,
                      @RequestBody @Valid GradeRequest request) {
        gradeService.execute(userId, request);
    }

}
