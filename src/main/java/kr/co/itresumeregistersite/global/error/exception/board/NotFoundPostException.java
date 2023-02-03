package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotFoundPostException extends BusinessLogicException {

    public NotFoundPostException() {
        super(ErrorCode.NOT_FOUND_POST);
    }
}
