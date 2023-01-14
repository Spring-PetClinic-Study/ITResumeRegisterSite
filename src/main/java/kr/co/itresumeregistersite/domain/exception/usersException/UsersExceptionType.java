package kr.co.itresumeregistersite.domain.exception.usersException;

import kr.co.itresumeregistersite.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum UsersExceptionType implements BaseExceptionType {

    // 에러코드와 Http 상태코드 그리고 에러 메세지가 존재

    // 회원가입, 로그인을 할 경우
    ALREADY_EXIST_USERSIDENTITY(600, HttpStatus.OK, "이미 존재하는 아이디입니다!"),

    WRONG_PASSWORD(602, HttpStatus.OK, "비밀번호가 잘못되었습니다!"),

    NOT_FOUND_USERS(603, HttpStatus.OK, "회원정보가 없습니다!");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    UsersExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.getHttpStatus();
    }

    @Override
    public String getErrorMessage() {
        return this.getErrorMessage();
    }
}
