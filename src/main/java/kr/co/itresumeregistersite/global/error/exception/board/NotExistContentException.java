package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotExistContentException extends BusinessLogicException {

    public NotExistContentException() {
        super(ErrorCode.CONTENT_NOT_EXIST);
    }
}
