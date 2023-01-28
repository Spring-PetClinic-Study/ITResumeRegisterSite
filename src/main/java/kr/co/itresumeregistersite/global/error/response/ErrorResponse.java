package kr.co.itresumeregistersite.global.error.response;

import lombok.Getter;

@Getter
public class ErrorResponse {    // 예외에 대한 응답 정보를 저장하는 class

    private String message; // 예외 메세지 저장
    private String code;    // 예외를 세분화하기 위한 사용자 지정 코드
    private int status;     // Http 상태 값 저장 400, 404, 500 등,,
}
