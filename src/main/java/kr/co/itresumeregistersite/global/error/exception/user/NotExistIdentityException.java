package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotExistIdentityException extends BusinessLogicException {

    public NotExistIdentityException() {
        super(ErrorCode.IDENTITY_INPUT_WRONG);
    }
}
