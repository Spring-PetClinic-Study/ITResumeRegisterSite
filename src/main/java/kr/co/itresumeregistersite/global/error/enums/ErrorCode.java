package kr.co.itresumeregistersite.global.error.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode { // 예외에 대한 정보를 담고 있는 enum class


    // common
    SUCCESS(200, HttpStatus.OK, "실행에 성공했습니다"),

    FAIL(203, HttpStatus.BAD_REQUEST, "실행에 실패했습니다"),

    INTERNAL_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류"),

    DB_ERROR(600, HttpStatus.INTERNAL_SERVER_ERROR, "데이터베이스 오류"),

    NOT_FOUND(404, HttpStatus.NOT_FOUND, "해당 정보가 없습니다"),



    // user
//    LOGIN_SUCCESS(200, HttpStatus.OK, "로그인에 성공했습니다"),
//
//    LOGIN_FAIL(203, HttpStatus.BAD_REQUEST, "로그인에 실패했습니다"),
//
//    GET_USER_INFO(200, HttpStatus.OK, "회원정보 조회에 성공했습니다"),
//
//    CREATED_USER(200, HttpStatus.OK, "회원가입에 성공했습니다"),
//
//    UPDATE_USER(200, HttpStatus.OK, "회원정보 수정에 성공했습니다"),
//
//    UPDATE_PASSWORD_USER(200, HttpStatus.OK, "회원 비밀번호 수정에 성공했습니다"),
//
//    DELETE_USER(200, HttpStatus.OK, "회원탈퇴 성공했습니다"),

    NOT_FOUND_USER(404, HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다"),

    WORNG_IDENTITY(400, HttpStatus.BAD_REQUEST, "존재하지 않는 아이디입니다!"),

    WRONG_PASSWORD(400, HttpStatus.BAD_REQUEST, "존재하지 않는 비밀번호입니다!"),

    DUPLICATED_IDENTITY(400, HttpStatus.BAD_REQUEST, "중복된 아이디는 사용할 수 없습니다!"),

    IDENTITY_VALUE_NULL(204, HttpStatus.NO_CONTENT, "아이디를 입력해주세요!"),

    PASSWORD_VALUE_NULL(204, HttpStatus.NO_CONTENT, "비밀번호를 입력해주세요!"),

    INVALID_PARAMETER(204, HttpStatus.BAD_REQUEST, "잘못된 매개변수입니다!"),



    // board
    TITLE_NOT_EXIST(204, HttpStatus.NO_CONTENT, "제목이 존재하지 않습니다! 제목을 작성해주세요!"),

    WRITER_NOT_EXIST(204, HttpStatus.NO_CONTENT, "작성자가 존재하지 않습니다! 작성자를 작성해주세요!"),

    CONTENT_NOT_EXIST(204, HttpStatus.NO_CONTENT, "내용이 존재하지 않습니다! 내용을 작성해주세요!"),

    POST_NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다!");



    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;
}
