package com.example.dokgodieserver.domain.user.exception;

import com.example.dokgodieserver.global.error.exception.BusinessException;
import com.example.dokgodieserver.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }

}
