package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.errorCode.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class WrongPasswordException extends BusinessLogicException {

    public WrongPasswordException() {
        super(ErrorCode.WRONG_PASSWORD);
    }
}
