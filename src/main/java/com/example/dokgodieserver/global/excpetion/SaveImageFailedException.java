package com.example.dokgodieserver.global.excpetion;

import com.example.dokgodieserver.global.error.exception.BusinessException;
import com.example.dokgodieserver.global.error.exception.ErrorCode;

public class SaveImageFailedException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new SaveImageFailedException();

    private SaveImageFailedException() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }

}
