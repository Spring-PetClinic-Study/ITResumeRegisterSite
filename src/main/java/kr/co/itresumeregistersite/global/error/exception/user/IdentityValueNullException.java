package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class IdentityValueNullException extends BusinessLogicException {

    public IdentityValueNullException() {
        super(ErrorCode.IDENTITY_VALUE_NULL);
    }
}
