package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class TitleNotExistException extends BusinessLogicException {

    public TitleNotExistException() {
        super(ErrorCode.TITLE_NOT_EXIST);
    }
}
