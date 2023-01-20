package kr.co.itresumeregistersite.domain.exception;

import kr.co.itresumeregistersite.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum NoSuchDataExceptionType implements BaseExceptionType {

    // 에러코드와 Http 상태코드 그리고 에러 메세지가 존재

    //==회원가입, 로그인을 할 경우==//
    ALREADY_EXIST_USERSIDENTITY(600, HttpStatus.CONFLICT, "이미 존재하는 아이디입니다!"),

    WRONG_PASSWORD(601, HttpStatus.BAD_REQUEST, "비밀번호가 잘못되었습니다!"),

    NOT_FOUND_USERS(602, HttpStatus.NOT_FOUND, "회원정보가 없습니다!"),



    //==게시글 내용 미입력할 경우==//
    TITLE_NOT_EXIST(603, HttpStatus.OK, "제목을 입력해주세요!"),

    WRITER_NOT_EXIST(604, HttpStatus.OK, "작성자를 입력해주세요!"),

    CONTENT_NOT_EXIST(605, HttpStatus.OK, "내용을 입력해주세요!"),

    NOT_FOUND_POST(606, HttpStatus.OK, "작성된 게시글이 없습니다!");


    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    NoSuchDataExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }


    @Override
    public int getErrorCode() {
        return this.getErrorCode();
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
