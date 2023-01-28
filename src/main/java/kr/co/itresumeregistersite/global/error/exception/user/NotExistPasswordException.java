package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotExistPasswordException extends BusinessLogicException {

    public NotExistPasswordException() {
        super(ErrorCode.WRONG_PASSWORD);
    }
}
