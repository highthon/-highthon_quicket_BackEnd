package com.example.dokgodieserver.domain.article.service;

import com.example.dokgodieserver.domain.article.domain.Article;
import com.example.dokgodieserver.domain.article.domain.repository.ArticleRepository;
import com.example.dokgodieserver.domain.article.presentation.dto.response.QueryReelsResponse;
import com.example.dokgodieserver.domain.article.presentation.dto.response.QueryReelsResponse.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class QueryReelsService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public QueryReelsResponse execute() {

        List<Article> articleList = articleRepository.findAll();
        Random random = new Random();
        Article article = articleList.get(random.nextInt(articleList.size()));

        return QueryReelsResponse.builder()
                .title(article.getTitle())
                .reels(article.getReels())
                .articleLink(article.getArticleLink())
                .userInfo(UserResponse.builder()
                        .userId(article.getUser().getId())
                        .name(article.getUser().getName())
                        .profileImageUrl(article.getUser().getProfileImageUrl())
                        .build())
                .build();
    }

}
