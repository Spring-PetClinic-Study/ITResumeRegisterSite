package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class DuplicatedCodeException extends BusinessLogicException {

    // 아이디 중복 시 예외처리
    public DuplicatedCodeException() {
        super(ErrorCode.IDENTITY_DUPLICATION);
    }
}
