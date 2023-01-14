package com.example.dokgodieserver.domain.user.service;

import com.example.dokgodieserver.domain.user.domain.User;
import com.example.dokgodieserver.domain.user.facade.UserFacade;
import com.example.dokgodieserver.domain.user.presentation.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public MyPageResponse execute() {

        User currentUser = userFacade.getCurrentUser();

        return MyPageResponse.builder()
                .name(currentUser.getName())
                .accountId(currentUser.getAccountId())
                .profileImageUrl(currentUser.getProfileImageUrl())
                .grade(currentUser.getResult())
                .userTalkListList(userFacade.getUserTalkList(currentUser.getConversationUserList()))
                .build();
    }

}
