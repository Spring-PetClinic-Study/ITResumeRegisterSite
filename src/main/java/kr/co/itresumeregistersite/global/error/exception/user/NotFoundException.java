package kr.co.itresumeregistersite.global.error.exception.user;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotFoundException extends BusinessLogicException {


    public NotFoundException() {
        super(ErrorCode.NOT_FOUND_USER);
    }
}
