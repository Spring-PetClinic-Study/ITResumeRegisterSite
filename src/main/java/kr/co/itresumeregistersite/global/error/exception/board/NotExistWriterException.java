package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotExistWriterException extends BusinessLogicException {

    public NotExistWriterException() {
        super(ErrorCode.WRITER_INPUT_INVALID);
    }
}
