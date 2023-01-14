package com.example.dokgodieserver.domain.article.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ArticleRequest {

    @NotNull
    private String title;

    @NotNull
    private String articleLink;

}
