package com.example.dokgodieserver.domain.article.service;

import com.example.dokgodieserver.domain.article.domain.Article;
import com.example.dokgodieserver.domain.article.domain.repository.ArticleRepository;
import com.example.dokgodieserver.domain.article.exception.ArticleAlreadyExistsException;
import com.example.dokgodieserver.domain.article.presentation.dto.request.ArticleRequest;
import com.example.dokgodieserver.domain.user.domain.User;
import com.example.dokgodieserver.domain.user.facade.UserFacade;
import com.example.dokgodieserver.infrastructure.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadArticleService {

    private final ArticleRepository articleRepository;
    private final S3Facade s3Facade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(ArticleRequest request, MultipartFile file) {

        if(articleRepository.findByTitle(request.getTitle()).isPresent()) {
            throw ArticleAlreadyExistsException.EXCEPTION;
        }

        User currentUser = userFacade.getCurrentUser();

        String fileName = s3Facade.uploadImage(file);

        articleRepository.save(Article.builder()
                .title(request.getTitle())
                .articleLink(request.getArticleLink())
                .reels(fileName)
                .user(currentUser)
                .build());
    }

}
