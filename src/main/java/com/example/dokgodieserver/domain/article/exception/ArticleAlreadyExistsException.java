package com.example.dokgodieserver.domain.article.exception;

import com.example.dokgodieserver.global.error.exception.BusinessException;
import com.example.dokgodieserver.global.error.exception.ErrorCode;

public class ArticleAlreadyExistsException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ArticleAlreadyExistsException();

    private ArticleAlreadyExistsException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
