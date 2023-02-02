package kr.co.itresumeregistersite.global.error.exception.resume;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NotFoundResumeException extends BusinessLogicException {

    public NotFoundResumeException() {
        super(ErrorCode.NOT_FOUND_RESUME);
    }
}
