package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class ContentNotExistException extends BusinessLogicException {

    public ContentNotExistException() {
        super(ErrorCode.CONTENT_NOT_EXIST);
    }
}
