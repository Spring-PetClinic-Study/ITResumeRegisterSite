package kr.co.itresumeregistersite.domain.exception;

import kr.co.itresumeregistersite.global.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    // Controller에서 발생한 UsersException을 포함해, 이후 발생할 커스텀 예외들을 처리해줄 수 있도록 함
    // 서버에서 예외가 발생하더라도, 상태코드는 200을 반환하도록 설정
    @ExceptionHandler(BaseException.class)
    public ResponseEntity handleBaseEx(BaseException exception) {
        log.error("BaseException errorMessage() : {}", exception.getExceptionType().getErrorMessage());
        log.error("BaseException errorCode() : {}", exception.getExceptionType().getErrorCode());

        return new ResponseEntity(new ExceptionDto(exception.getExceptionType().getErrorCode())
                , exception.getExceptionType().getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleUsersEx(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity(HttpStatus.OK);
    }


    @Data
    @AllArgsConstructor
    static class ExceptionDto {
        private Integer errorCode;
    }
}
