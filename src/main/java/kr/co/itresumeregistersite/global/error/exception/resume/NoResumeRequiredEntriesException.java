package kr.co.itresumeregistersite.global.error.exception.resume;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import kr.co.itresumeregistersite.global.error.exception.BusinessLogicException;

public class NoResumeRequiredEntriesException extends BusinessLogicException {

    public NoResumeRequiredEntriesException() {
        super(ErrorCode.NO_RESUME_REQUIRED_ENTRIES_FILLED_OUT);
    }
}
