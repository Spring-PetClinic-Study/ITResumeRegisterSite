package kr.co.itresumeregistersite.global.error.response;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ResponseFormat<T> {   // 공통 응답 모델

    // API의 처리여부, 상태, 메세지가 담긴 데이터 -> 이 응답을 다른 모든 응답이 상속받아 사용할 수 있도록 함
    private boolean result; // 응답 성공 여부
    private String message; // 응답 메세지
    private int status;     // 응답코드 : >= 0 정상, < 0 비정상
    private T data;         // 데이터

    public static ResponseFormat ok() {
        return ResponseFormat.builder()
                .result(true)
                .data(null)
                .message(ErrorCode.SUCCESS.getMessage())
                .status(ErrorCode.SUCCESS.getStatus())
                .build();
    }

    public static ResponseFormat ok(String message) {
        return ResponseFormat.builder()
                .result(true)
                .data(null)
                .message(ErrorCode.SUCCESS.getMessage())
                .status(ErrorCode.SUCCESS.getStatus())
                .build();
    }

    public static ResponseFormat fail() {
        return ResponseFormat.builder()
                .result(false)
                .data(null)
                .message(ErrorCode.FAIL.getMessage())
                .status(ErrorCode.FAIL.getStatus())
                .build();
    }

    public static <T> ResponseFormat ok(T data) {
        return ResponseFormat.builder()
                .result(true)
                .data(data)
                .message(ErrorCode.SUCCESS.getMessage())
                .status(ErrorCode.SUCCESS.getStatus())
                .build();
    }
}
