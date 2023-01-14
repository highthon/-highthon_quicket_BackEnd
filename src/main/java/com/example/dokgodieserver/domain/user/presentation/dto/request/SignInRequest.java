package com.example.dokgodieserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class SignInRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,20}$", message = "비밀번호는는 8자에서 20자 사이입니다.")
    private String password;

}
