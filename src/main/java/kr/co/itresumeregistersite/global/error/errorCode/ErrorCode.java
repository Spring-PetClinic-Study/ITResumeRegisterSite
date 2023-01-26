package kr.co.itresumeregistersite.global.error.errorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // user
    USER_NOT_FOUND(400, HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다!"),
    WRONG_IDENTITY(401, HttpStatus.BAD_REQUEST, "존재하지 않는 아이디입니다!"),
    WRONG_PASSWORD(402, HttpStatus.BAD_REQUEST, "존재하지 않는 비밀번호입니다!"),
    DUPLICATED_IDENTITY(403, HttpStatus.BAD_REQUEST, "중복된 아이디는 사용할 수 없습니다!"),

    // board
    TITLE_NOT_EXIST(404, HttpStatus.NOT_FOUND, "제목이 존재하지 않습니다! 제목을 작성해주세요!"),
    WRITER_NOT_EXIST(405, HttpStatus.NOT_FOUND, "작성자가 존재하지 않습니다! 작성자를 작성해주세요!"),
    CONTENT_NOT_EXIST(406, HttpStatus.NOT_FOUND, "내용이 존재하지 않습니다! 내용을 작성해주세요!"),
    POST_NOT_FOUND(407, HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다!");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;
}
