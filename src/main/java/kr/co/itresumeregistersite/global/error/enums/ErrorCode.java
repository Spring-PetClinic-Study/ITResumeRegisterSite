package kr.co.itresumeregistersite.global.error.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode { // 예외에 대한 정보를 담고 있는 enum class

    // Common
    SUCCESS(200, HttpStatus.OK, "Successfully Executed"),
    FAIL(203, HttpStatus.BAD_REQUEST, "Execution Failed"),
    INVAILD_INPUT_VALUE(400, HttpStatus.BAD_REQUEST, "Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, HttpStatus.BAD_REQUEST, "Invalid Input Value"),
    HANDLE_ACCESS_DENIED(403, HttpStatus.BAD_REQUEST, "Access is Denied"),
    INTERNAL_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    DB_ERROR(600, HttpStatus.INTERNAL_SERVER_ERROR, "DataBase Error"),
    PARAMETER_INPUT_INVALID(204, HttpStatus.BAD_REQUEST, "Parameter Input is Invalid"),

    // User
    IDENTITY_DUPLICATION(400, HttpStatus.BAD_REQUEST, "Identity is Duplicated"),
    EMAIL_DUPLICATION(400, HttpStatus.BAD_REQUEST, "Email is Duplicated"),
    LOGIN_INPUT_INVALID(400, HttpStatus.BAD_REQUEST, "Login Input is Invalid"),
    IDENTITY_INPUT_INVALID(204, HttpStatus.NO_CONTENT, "Identity Input is Invalid"),
    PASSWORD_INPUT_INVALID(204, HttpStatus.NO_CONTENT, "Password Input is Invalid"),
    IDENTITY_INPUT_WRONG(400, HttpStatus.BAD_REQUEST, "Identity Input is Wrong"),
    PASSWORD_INPUT_WRONG(400, HttpStatus.BAD_REQUEST, "Password Input is Wrong"),
    NOT_FOUND_USER(404, HttpStatus.NOT_FOUND, "Not Found User"),

    // Post
    TITLE_INPUT_INVALID(204, HttpStatus.NO_CONTENT, "Title Input is Invalid"),
    WRITER_INPUT_INVALID(204, HttpStatus.NO_CONTENT, "Writer Input is Invalid"),
    CONTENT_INPUT_INVALID(204, HttpStatus.NO_CONTENT, "Content Input is Invalid"),
    NOT_FOUND_POST(404, HttpStatus.NOT_FOUND, "Not Found Post");

    private final int status;
    private final HttpStatus code;
    private final String message;
}
