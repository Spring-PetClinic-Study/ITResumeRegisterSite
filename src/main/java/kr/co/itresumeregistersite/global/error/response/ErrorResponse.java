package kr.co.itresumeregistersite.global.error.response;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorResponse {    // 예외에 대한 응답 정보를 저장하는 class

    private HttpStatus code;    // 예외를 세분화하기 위한 사용자 지정 코드
    private String message; // 예외 메세지 저장
    private int status;     // Http 상태 값 저장 400, 404, 500 등,,

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .status(errorCode.getStatus())
                .build();

    }
}
