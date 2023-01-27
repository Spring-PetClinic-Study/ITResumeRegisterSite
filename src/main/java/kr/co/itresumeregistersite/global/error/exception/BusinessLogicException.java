package kr.co.itresumeregistersite.global.error.exception;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;

public class BusinessLogicException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessLogicException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
