package com.example.dokgodieserver.domain.user.exception;

import com.example.dokgodieserver.global.error.exception.BusinessException;
import com.example.dokgodieserver.global.error.exception.ErrorCode;

public class PasswordMisMatchException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
