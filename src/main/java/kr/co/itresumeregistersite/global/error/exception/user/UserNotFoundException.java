package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.errorCode.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class UserNotFoundException extends BusinessLogicException {


    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
