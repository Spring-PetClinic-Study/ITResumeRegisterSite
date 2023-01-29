package kr.co.itresumeregistersite.domain.user.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignInDto {

    private Long userId;

    @NotBlank(message = "아이디를 입력해주세요")
    private String identity;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
}
