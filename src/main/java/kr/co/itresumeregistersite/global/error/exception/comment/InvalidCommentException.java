package kr.co.itresumeregistersite.global.error.exception.comment;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class InvalidCommentException extends BusinessLogicException {

    public InvalidCommentException() {
        super(ErrorCode.COMMENT_INPUT_INVALID);
    }
}
