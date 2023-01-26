package kr.co.itresumeregistersite.global.error.exception.board;

import kr.co.itresumeregistersite.global.error.errorCode.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class PostNotFoundException extends BusinessLogicException {

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
