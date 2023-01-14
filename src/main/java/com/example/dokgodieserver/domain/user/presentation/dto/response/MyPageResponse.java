package com.example.dokgodieserver.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class MyPageResponse {

    private final String name;
    private final String accountId;
    private final String profileImageUrl;
    private final int grade;
    private List<UserTalkResponse> userTalkListList;

    @Getter
    @Builder
    public static class UserTalkResponse {
        private final Long userId;
        private final String name;
        private final int grade;
        private final String profileImageUrl;

    }

}
