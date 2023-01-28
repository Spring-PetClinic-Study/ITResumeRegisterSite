package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class WriterNotExistException extends BusinessLogicException {

    public WriterNotExistException() {
        super(ErrorCode.WRITER_NOT_EXIST);
    }
}
