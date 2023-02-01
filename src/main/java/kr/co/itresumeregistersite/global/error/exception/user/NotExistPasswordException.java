package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotExistPasswordException extends BusinessLogicException {

    public NotExistPasswordException() {
        super(ErrorCode.PASSWORD_INPUT_INVALID);
    }
}
