package com.example.dokgodieserver.domain.article.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryReelsResponse {
    private final String title;
    private final String reels;
    private final String articleLink;
    private final UserResponse userInfo;


    @Getter
    @Builder
    public static class UserResponse {
        private final Long userId;
        private final String name;
        private final String profileImageUrl;
    }
}
