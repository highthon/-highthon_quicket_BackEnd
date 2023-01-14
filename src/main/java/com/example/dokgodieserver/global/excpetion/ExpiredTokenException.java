package com.example.dokgodieserver.global.excpetion;

import com.example.dokgodieserver.global.error.exception.BusinessException;
import com.example.dokgodieserver.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}
