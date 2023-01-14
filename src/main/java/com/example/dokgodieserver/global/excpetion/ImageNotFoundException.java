package com.example.dokgodieserver.global.excpetion;

import com.example.dokgodieserver.global.error.exception.BusinessException;
import com.example.dokgodieserver.global.error.exception.ErrorCode;

public class ImageNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }

}
