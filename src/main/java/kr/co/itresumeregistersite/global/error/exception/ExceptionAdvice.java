package kr.co.itresumeregistersite.global.error.exception;

import kr.co.itresumeregistersite.global.error.exception.user.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    // NotFoundException을 지정해서 잡아낸다 (즉, 특정 Exception을 지정해서 잡아낸다)
    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(NotFoundException e) {
        return "NotFoundException Occurred";
    }

    // DuplicatedCodeException을 지정해서 잡아낸다
    @ExceptionHandler(DuplicatedCodeException.class)
    public String duplicatedCodeException(DuplicatedCodeException e) {
        return "DuplicatedCodeException Occurred";
    }

    // NotExistPasswordException을 지정해서 잡아낸다
    @ExceptionHandler(NotExistPasswordException.class)
    public String notExistPasswordException(NotExistPasswordException e) {
        return "NotExistPasswordException Occurred";
    }

    // NotExistIdentityException을 지정해서 잡아낸다
    @ExceptionHandler(NotExistIdentityException.class)
    public String notExistIdentityException(NotExistIdentityException e) {
        return "NotExistIdentityException Occurred";
    }

    // InvalidParameterException을 지정해서 잡아낸다
    @ExceptionHandler(InvalidParameterException.class)
    public String invalidParameterException(InvalidParameterException e) {
        return "InvalidParameterException Occurred";
    }
}
