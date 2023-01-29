package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotExistTitleException extends BusinessLogicException {

    public NotExistTitleException() {
        super(ErrorCode.TITLE_NOT_EXIST);
    }
}
