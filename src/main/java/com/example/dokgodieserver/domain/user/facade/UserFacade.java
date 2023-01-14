package com.example.dokgodieserver.domain.user.facade;

import com.example.dokgodieserver.domain.conversation.domain.ConversationUser;
import com.example.dokgodieserver.domain.user.domain.User;
import com.example.dokgodieserver.domain.user.domain.repository.UserRepository;
import com.example.dokgodieserver.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.dokgodieserver.domain.user.presentation.dto.response.MyPageResponse.*;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public List<UserTalkResponse> getUserTalkList(List<ConversationUser> conversationUserList) {
        return conversationUserList
                .stream()
                .map(conversationUser -> UserTalkResponse.builder()
                        .userId(conversationUser.getUser().getId())
                        .name(conversationUser.getUser().getName())
                        .grade(conversationUser.getUser().getResult())
                        .profileImageUrl(conversationUser.getUser().getProfileImageUrl())
                        .build())
                .toList();
    }

}
