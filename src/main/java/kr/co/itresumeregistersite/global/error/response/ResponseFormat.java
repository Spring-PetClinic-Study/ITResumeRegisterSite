package kr.co.itresumeregistersite.global.error.response;

import kr.co.itresumeregistersite.global.error.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ResponseFormat {

    private boolean result;
    private String message;
    private int status;

    public static ResponseFormat ok(String message) {
        return ResponseFormat.builder()
                .result(true)
                .message(ErrorCode.SUCCESS.getErrorMessage())
                .status(ErrorCode.SUCCESS.getErrorCode())
                .build();
    }
}
