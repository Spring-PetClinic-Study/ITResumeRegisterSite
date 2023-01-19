package kr.co.itresumeregistersite.domain.exception.usersException;

import kr.co.itresumeregistersite.global.exception.BaseException;
import kr.co.itresumeregistersite.global.exception.BaseExceptionType;

public class NoSuchDataException extends BaseException {

    // BaseExceptionType을 유저변수로 가지고 있으며, 생성자를 통해 생성하는 순간 ExceptionType을 설정하도록 만들어 줌
    private BaseExceptionType exceptionType;

    public NoSuchDataException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }


}
