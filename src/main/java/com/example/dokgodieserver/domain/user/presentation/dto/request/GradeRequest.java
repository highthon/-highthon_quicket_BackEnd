package com.example.dokgodieserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;

@Getter
@NoArgsConstructor
public class GradeRequest {
    @Max(5)
    private int grade;
}
