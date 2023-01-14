package com.example.dokgodieserver.domain.article.presentation;

import com.example.dokgodieserver.domain.article.presentation.dto.request.ArticleRequest;
import com.example.dokgodieserver.domain.article.presentation.dto.response.QueryReelsResponse;
import com.example.dokgodieserver.domain.article.service.QueryReelsService;
import com.example.dokgodieserver.domain.article.service.UploadArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/articles")
@RestController
public class ArticleController {

    private final UploadArticleService uploadArticleService;
    private final QueryReelsService queryReelsService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadArticle(@RequestPart ArticleRequest request,
                              @RequestPart MultipartFile file) {
        uploadArticleService.execute(request, file);
    }

    @GetMapping("/reels")
    public QueryReelsResponse queryReels() {
        return queryReelsService.execute();
    }

}
