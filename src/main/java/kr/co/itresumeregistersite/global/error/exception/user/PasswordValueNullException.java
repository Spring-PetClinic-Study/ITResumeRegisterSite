package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class PasswordValueNullException extends BusinessLogicException {

    public PasswordValueNullException() {
        super(ErrorCode.PASSWORD_VALUE_NULL);
    }
}
