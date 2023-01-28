package kr.co.itresumeregistersite.global.error.exception;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;

public class BusinessLogicException extends RuntimeException {  // 여러가지 예외의 기본이 되는 class
    // 모든 예외 정보는 ErrorCode를 통해서 전달 받는다

    private final ErrorCode errorCode;

    public BusinessLogicException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
