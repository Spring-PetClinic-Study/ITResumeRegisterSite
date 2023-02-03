package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class IllegalArgumentException extends BusinessLogicException {

    public IllegalArgumentException() {
        super(ErrorCode.NOT_FOUND_POST);
    }
}
